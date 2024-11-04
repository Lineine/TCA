from collections import defaultdict
import multiprocessing
import pickle
import re
import subprocess
import os
import shutil
from numpy import average
import pandas as pd
import csv
import psutil
from tqdm import trange
from tenacity import retry
import glob
from bs4 import BeautifulSoup
import time
import xml.etree.ElementTree as ET
from lxml import etree

# windows运行代码
@retry
def validate_maven_project(project_path, file_path):
    try:
        for root, dirs, files in os.walk(file_path):
            for file in files:
                source_path = os.path.join(root, file)
                
                # 构造目标路径
                destination_path = os.path.join(project_path + '/src/test/java/net/mooctest', file)

                # 复制文件
                shutil.copy(source_path, destination_path)        
        
        start_time = time.time() 

        # 使用 Maven 构建项目 windows使用['mvn', 'clean', 'install']
        build_process = subprocess.run(['mvn clean install'], cwd=project_path, capture_output=True, text=True, shell=True)
        end_time = time.time()
        build_process1 = subprocess.run(['mvn org.pitest:pitest-maven:mutationCoverage'], cwd=project_path, capture_output=True, text=True, shell=True)
        
        # 如果构建成功，返回 True
        if build_process.returncode == 0 and build_process1.returncode == 0:
            return True, end_time - start_time
        else:
            if build_process.returncode != 0:
                # 如果构建失败，打印错误信息并返回 False
                print("Build error:", build_process.stderr)
            if build_process1.returncode != 0:
                # 如果构建失败，打印错误信息并返回 False
                print("Build error:", build_process1.stderr)
            return False, 0
    except Exception as e:
        print(e)
        return False, 0
    finally:
        for root, dirs, files in os.walk(file_path):
            for file in files:
                file_path = os.path.join(project_path + '/src/test/java/net/mooctest', file)
                os.remove(file_path)

@retry
def find_class_name(file_path):
    with open(file_path, 'r', encoding='utf-8') as file:
        for line in file:
            if line.startswith("public class"):
                words = line.split()
                class_name = words[2].split('&')[0]
                return class_name

@retry        
def extract_num_from_title(title_content):
    # 匹配形如"All {num} branches missed."的格式
    pattern_all_missed = r"All (\d+) branches missed."
    match_all_missed = re.match(pattern_all_missed, title_content)
    if match_all_missed:
        num = int(match_all_missed.group(1))
        return [0, num]

    # 匹配形如"All {num} branches covered."的格式
    pattern_all_covered = r"All (\d+) branches covered."
    match_all_covered = re.match(pattern_all_covered, title_content)
    if match_all_covered:
        num = int(match_all_covered.group(1))
        return [num, num]

    # 匹配形如"{num1} of {num2} branches missed."的格式
    pattern_of_missed = r"(\d+) of (\d+) branches missed."
    match_of_missed = re.match(pattern_of_missed, title_content)
    if match_of_missed:
        num1 = int(match_of_missed.group(1))
        num2 = int(match_of_missed.group(2))
        return [num1, num2]

    return None


def read_coverage_point(directory):
    
    classname_to_bc_point = {}
    for root, dirs, files in os.walk(directory):
        for file in files:
            if file.endswith(".java.html"):
                file_path = os.path.join(root, file)
                class_name = file.split('.')[0] # find_class_name(file_path)
                with open(file_path, "r", encoding="utf-8") as file:
                    html_content = file.readlines()[1:]
                # 找到包含title的span标签
                for line in html_content:
                    if '<span class="' in line and 'title' in line:
                        span_start = line.find('title="') + len('title="')
                        span_end = line.find('"', span_start)
                        title_content = line[span_start:span_end]
                        id_start = line.find('id="') + len('id="')
                        id_end = line.find('"', id_start)
                        id = line[id_start:id_end]
                        num_range = extract_num_from_title(title_content)
                        classname_to_bc_point[(class_name, id)] = [num_range[0], num_range[1]]

    return classname_to_bc_point

@retry
def read_coverage(file_path):
    # 读取CSV文件
    df = pd.read_csv(file_path)

    # 检查文件中是否存在指定的列
    if 'INSTRUCTION_COVERED' in df.columns and 'BRANCH_COVERED' in df.columns:
        # 计算每一行的和
        BRANCH_COVERED = df['BRANCH_COVERED'].sum()
        INSTRUCTION_COVERED = df['INSTRUCTION_COVERED'].sum()
        BRANCH_MISSED = df['BRANCH_MISSED'].sum()
        INSTRUCTION_MISSED = df['INSTRUCTION_MISSED'].sum()
        branch_coverage = BRANCH_COVERED/(BRANCH_COVERED + BRANCH_MISSED) if (BRANCH_COVERED + BRANCH_MISSED) > 0 else 0
        instruction_coverage = INSTRUCTION_COVERED/(INSTRUCTION_COVERED + INSTRUCTION_MISSED)  if (INSTRUCTION_COVERED + INSTRUCTION_MISSED) > 0 else 0
        coverage = branch_coverage/2 + instruction_coverage/2
        # 输出结果
        print("分支覆盖率：", branch_coverage)
        print("语句覆盖率：", instruction_coverage)
        print("平均覆盖率：", coverage)
        return [branch_coverage, instruction_coverage, coverage]
    else:
        print("文件中缺少指定的列")
        return 0
    
@retry    
def count_lines_and_length(directory):
    total_lines = 0
    total_length = 0

    # 遍历目录中的所有文件和子目录
    for root, dirs, files in os.walk(directory):
        for file in files:
            # 确保文件以.java为后缀
            if file.endswith('.java'):
                file_path = os.path.join(root, file)
                with open(file_path, 'r', encoding='utf-8') as f:
                    # 统计文件的行数和长度
                    lines = f.readlines()
                    total_lines += len(lines)
                    total_length += sum(len(line) for line in lines)

    return [total_lines, total_length]

def read_mutation_score(pitest_path):
    with open(pitest_path, 'r', encoding='utf-8') as file:
        soup = BeautifulSoup(file, 'html.parser')

    # 查找<h3>Project Summary</h3>
    project_summary_h3 = soup.find('h3', string='Project Summary')

    # 获取紧接在<h3>Project Summary</h3>后的第一个table
    table = project_summary_h3.find_next('table')

    # 获取table中的tbody
    tbody = table.find('tbody')

    # 获取tbody中的最后一个td
    last_td = tbody.find_all('td')[-1]

    # 获取最后一个td中的最后一个div
    last_div = last_td.find_all('div')[-1]

    # 提取最后一个div中的文本内容
    data = last_div.get_text(strip=True)

    numerator, denominator = map(int, data.split('/'))
    decimal_value = numerator / denominator

    return decimal_value

def update_mutation_test_seed(xml_file, new_seed_value):
    # 解析XML文件
    tree = etree.parse(xml_file)
    root = tree.getroot()

    # 定义命名空间
    ns = {'maven': 'http://maven.apache.org/POM/4.0.0'}

    # 查找指定插件并修改mutationTestSeed
    for plugin in root.xpath("//maven:plugin[maven:groupId='org.pitest']", namespaces=ns):
        configuration = plugin.find("maven:configuration", namespaces=ns)
        if configuration is not None:
            mutation_test_seed = configuration.find("maven:mutationTestSeed", namespaces=ns)
            if mutation_test_seed is not None:
                mutation_test_seed.text = str(new_seed_value)
                print(f"Updated mutationTestSeed to: {new_seed_value}")
                break

    # 保存修改后的XML文件
    tree.write(xml_file, encoding="utf-8", xml_declaration=True)


@retry
def clean_directory(path):
    # 获取目录中的所有文件和文件夹
    files_and_folders = os.listdir(path)
    
    for item in files_and_folders:
        item_path = os.path.join(path, item)
        
        # 如果是文件夹，递归删除
        if os.path.isdir(item_path):
            if item not in ['src', 'target']:
                clean_directory(item_path)
        # 如果是文件，删除除了指定文件之外的所有文件
        else:
            if item not in ['pom.xml', 'test_operational.iml']:
                os.remove(item_path)
    # 遍历指定路径下的所有文件和文件夹
    for root, dirs, files in os.walk(path + '/src/test'):
        # 删除所有文件
        for file in files:
            file_path = os.path.join(root, file)
            os.remove(file_path)
@retry
def get_test_ids(directory):
    test_ids = []
    for root, dirs, files in os.walk(directory):
        for dir_name in dirs:
            if dir_name.startswith('test_'):
                test_ids.append(int(dir_name.split('_')[1]))
    return sorted(test_ids)

def merge_dicts_in_folder(folder_path):
    merged_dict = {}

    # 遍历指定文件夹下所有的 pkl 文件
    for filename in os.listdir(folder_path):
        if filename.endswith('.pkl'):
            file_path = os.path.join(folder_path, filename)
            with open(file_path, 'rb') as f:
                data = pickle.load(f)
                # 合并字典
                for key, value in data.items():
                    if key in merged_dict:
                        # 更新已有的 key 对应的 list，取原来的值和当前值的最大值
                        merged_dict[key][0] = max(merged_dict[key][0], value[0])
                        merged_dict[key][1] = max(merged_dict[key][1], value[1])
                    else:
                        # 添加新的 key-value 对
                        merged_dict[key] = value

    return merged_dict

@retry
def kill_processes(user, keyword):
    for proc in psutil.process_iter(['pid', 'username', 'cmdline']):
        if proc.info['username'] == user and keyword in ' '.join(proc.info['cmdline']):
            try:
                print(f"Killing process with PID {proc.pid}: {' '.join(proc.info['cmdline'])}")
                subprocess.run(['kill', str(proc.pid)])
            except Exception as e:
                print(f"Failed to kill process with PID {proc.pid}: {e}")

file_path = os.path.abspath(os.path.join(os.path.dirname(__file__), "../globals.py"))
with open(file_path, 'r') as file:
    for line in file:
        # 忽略注释行和空行
        if line.strip() and not line.strip().startswith('#'):
            if 'SYSTEM_PATH =' in line:
                _, system_path = map(str.strip, line.split('='))
                system_path = system_path.strip("'")
            elif 'PROJECT_NAME =' in line:
                _, project_name = map(str.strip, line.split('='))
                project_name = project_name.strip("'")
                break  

print("SYSTEM_PATH:", system_path)
print("PROJECT_NAME:", project_name)

if project_name.count('_') == 0:
    maven_project_path = system_path + '/CTCA/coverage_test/test_main/'  + project_name + '/test_operational'
else:
    maven_project_path = system_path + '/CTCA/coverage_test/test_main/'  + project_name.split('_')[0] + '/test_operational'


os.makedirs(system_path + '/CTCA/coverage_test/data/' + project_name, exist_ok=True)
os.makedirs(system_path + '/CTCA/coverage_test/data/' + project_name + '/branch_point', exist_ok=True)

# 指定未分割前的代码文件所在路径
folder_path = system_path + '/CTCA/data/last_data/' + project_name + '/first_code'

test_ids = get_test_ids(folder_path)

# 遍历文件夹下的所有文件
for i in trange(0, len(test_ids)):
    clean_directory(maven_project_path)
    print(i)
    id = test_ids[i]
    file_path = os.path.join(folder_path, f'test_{id}')
    print(file_path)
    mutation_scores = []
    time_useds = []
    for new_seed_value in [7, 42, 101, 2564, 987654321]:
        xml_file_path = maven_project_path + '/pom.xml'
        update_mutation_test_seed(xml_file_path, new_seed_value)
        # 调用编译和运行函数
        pool = multiprocessing.Pool(processes=1)
        result = pool.apply_async(validate_maven_project, (maven_project_path, file_path))
        timeout = 600
        try:
            # 在设置的超时时间内获取结果
            result, time_u = result.get(timeout=timeout)
        except multiprocessing.TimeoutError:
            # 如果在超时时间内未获取到结果，则终止进程并抛出异常
            pool.terminate()
            result = 0
            print("TimeOut!")

        time_useds.append(time_u)

        jacoco_path = maven_project_path + '/target/site/jacoco/jacoco.csv'
        if not os.path.exists(jacoco_path):
            result = False
            break

        pitest_path = glob.glob(maven_project_path + '/target/pit-reports/*/index.html')
        if pitest_path:
            pitest_path = pitest_path[0]
        else:
            result = False
            break
        
        if result:
            mutation_scores.append(read_mutation_score(pitest_path))

    coverage = 0
    # 打印结果
    if result:
        coverage = read_coverage(jacoco_path)
        mutation_score = average(mutation_scores)
        print(f'变异覆盖率：{mutation_score}')
        time_used = average(time_useds)
        print(f'平均耗时：{time_used}')
        '''
        # 打开文件，如果不存在则创建
        with open(system_path + '/CTCA/coverage_test/data/' + project_name + f'/branch_point/test_{id}.pkl', 'wb') as file:
            classname_to_bc_point = read_coverage_point(maven_project_path + '/target/site/jacoco/net.mooctest')
            pickle.dump(classname_to_bc_point, file)
        '''

        print("Maven project can be built.")
    else:
        print("Maven project build failed.")
    
    # 打开文件，如果不存在则创建
    with open(system_path + '/CTCA/coverage_test/data/' + project_name + '/initial_code_coverage.csv', 'a', newline='') as file:
        if result:
            # 要写入的数据
            data_to_append = [f'test_{id}'] + coverage + count_lines_and_length(file_path) + [mutation_score, time_used]
        else:
            data_to_append = [f'test_{id}', 'Maven project build failed.']

        writer = csv.writer(file)
        # 追加写入数据
        writer.writerow(data_to_append)

    # 清除构建过程中创建的文件
    clean_directory(maven_project_path)

    user = "lcd"
    keyword = "java"
    kill_processes(user, keyword)
'''
folder_path = system_path + '/CTCA/coverage_test/data/' + project_name + '/branch_point'
merged_dict = merge_dicts_in_folder(folder_path)
with open(system_path + '/CTCA/coverage_test/data/' + project_name + '/branch_point/test_total.pkl', 'wb') as file:
    pickle.dump(merged_dict, file)
'''

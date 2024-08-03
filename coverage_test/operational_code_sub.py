from collections import defaultdict
import subprocess
import os
import shutil
import pandas as pd
import csv
import psutil
from tqdm import trange
import multiprocessing


# windows运行代码
def validate_maven_project(project_path, file_path):       
    try:
        # 使用 Maven 构建项目 windows使用['mvn', 'clean', 'install']
        build_process = subprocess.run(['mvn clean install'], cwd=project_path, capture_output=True, text=True, shell=True)

    except Exception as e:
        print("Build error")
        print(e)
        return False
    # 如果构建成功，返回 True
    if build_process.returncode == 0:
        return True
    else:
        # 如果构建失败，打印错误信息并返回 False
        print("Build error:", build_process.stderr)
        return False
        
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

def count_lines_and_length(file_path):
    total_lines = 0
    total_length = 0

    with open(file_path, 'r', encoding='utf-8') as f:
        # 统计文件的行数和长度
        lines = f.readlines()
        total_lines += len(lines)
        total_length += sum(len(line) if not line.startswith("public") else 0 for line in lines)

    return [total_lines, total_length]

def clean_directory(path):
    # 获取目录中的所有文件和文件夹
    files_and_folders = os.listdir(path)
    
    for item in files_and_folders:
        item_path = os.path.join(path, item)
        
        # 如果是文件夹，递归删除
        if os.path.isdir(item_path):
            if item not in ['src', 'target']:
                shutil.rmtree(item_path)
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

def kill_processes(user, keyword):
    for proc in psutil.process_iter(['pid', 'username', 'cmdline']):
        if proc.info['username'] == user and keyword in ' '.join(proc.info['cmdline']):
            try:
                print(f"Killing process with PID {proc.pid}: {' '.join(proc.info['cmdline'])}")
                subprocess.run(['kill', str(proc.pid)])
            except Exception as e:
                print(f"Failed to kill process with PID {proc.pid}: {e}")

def csv_to_dict(filename):
    result_dict = {}
    ll_to_test_id = defaultdict(list)
    with open(filename, 'r', encoding='utf-8') as file:
        reader = csv.reader(file)
        for row in reader:
            key = (int(row[4]), int(row[5]))
            value = row[0]
            ll_to_test_id[key].append(value)
            result_dict[row[0]] = row[1:]
    return result_dict, ll_to_test_id

def compare_txt_files(file1, file2):
    with open(file1, 'r', encoding='utf-8') as f1, open(file2, 'r', encoding='utf-8') as f2:
        for line1, line2 in zip(f1, f2):
            if line1.startswith("public"):
                continue
            if line1 != line2:
                return False
        # 检查两个文件是否长度一致
        if f1.readline() != f2.readline():
            return False
    return True

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

# 指定文件夹路径
folder_path = system_path + '/CTCA/data/last_data/' + project_name + "/slicing_result"

if os.path.exists(system_path + '/CTCA/data/last_data/' + project_name + '/operational_result'):
    shutil.rmtree(system_path + '/CTCA/data/last_data/' + project_name + '/operational_result')
if os.path.exists(system_path + '/CTCA/coverage_test/data/' + project_name + '/operational_code_snippet_coverage2.csv'):
    os.remove(system_path + '/CTCA/coverage_test/data/' + project_name + '/operational_code_snippet_coverage2.csv')
os.makedirs(system_path + '/CTCA/data/last_data/' + project_name + '/operational_result', exist_ok=True)

csv_filename = system_path + '/CTCA/coverage_test/data/' + project_name.split('_')[0] + '/operational_code_snippet_coverage2.csv'
result_dict, ll_to_test_id = csv_to_dict(csv_filename)

# 遍历文件夹下的所有文件
for id in trange(0, len(os.listdir(folder_path))):
    
    # 清除构建过程中创建的文件
    clean_directory(maven_project_path)

    file_path = os.path.join(folder_path, f'test_{id}.txt')

    with open(system_path + '/CTCA/data/last_data/' + project_name + "/slicing_import/" + os.path.basename(file_path), 'r') as file:

        import_code = file.read()
    
    with open(system_path + '/CTCA/data/last_data/' + project_name + "/slicing_extract/" + os.path.basename(file_path), 'r') as file:

        extract_code = file.read()

    # 在这里可以添加你对 txt 文件的处理逻辑
    # 例如读取文件内容、进行文本分析等
    with open(file_path, 'r', encoding='utf-8') as file:

        java_code = import_code + 'public class ' + project_name.split('_')[0] + '_Test {\n' + file.read() + '\n}'

        # 将 Java 代码写入临时文件
        with open(maven_project_path + '/src/test/java/net/mooctest/' + project_name.split('_')[0] + '_Test.java', 'w') as file:
            file.write(java_code)

    shutil.copy2(file_path, system_path + '/CTCA/data/last_data/' + project_name + '/operational_result')
    
    line, leng = count_lines_and_length(maven_project_path + '/src/test/java/net/mooctest/' + project_name.split('_')[0] + '_Test.java')

    if (line, leng) in ll_to_test_id.keys():
        names = ll_to_test_id[(line, leng)]
        ac = False
        for name in names:
            file1 = system_path + '/CTCA/data/last_data/' + project_name.split('_')[0] + '/slicing_result/' + name + '.txt'
            file2 = system_path + '/CTCA/data/last_data/' + project_name + '/slicing_result/' + f'test_{id}.txt'
            if compare_txt_files(file1, file2):
                ac = True
                with open(system_path + '/CTCA/coverage_test/data/' + project_name + '/operational_code_snippet_coverage2.csv', 'a', newline='') as file:
                    data_to_append = [f'test_{id}'] + result_dict[name]
                
                    writer = csv.writer(file)
                    # 追加写入数据
                    writer.writerow(data_to_append)
                break
        if ac:
            os.remove(maven_project_path + '/src/test/java/net/mooctest/' + project_name.split('_')[0] + '_Test.java')
            
            continue

    # 调用编译和运行函数
    pool = multiprocessing.Pool(processes=1)
    result = pool.apply_async(validate_maven_project, (maven_project_path, file_path))
    timeout = 100
    try:
        # 在设置的超时时间内获取结果
        result = result.get(timeout=timeout)
    except multiprocessing.TimeoutError:
        # 如果在超时时间内未获取到结果，则终止进程并抛出异常
        pool.terminate()
        result = 0


    jacoco_path = maven_project_path + '/target/site/jacoco/jacoco.csv'
    if not os.path.exists(jacoco_path):
        result = False

    # 打印结果
    if result:
        shutil.copy2(file_path, system_path + '/CTCA/data/last_data/' + project_name + '/operational_result')
        coverage = read_coverage(jacoco_path)
        print("Maven project can be built.")
    else:
        print("Maven project build failed.")

    os.makedirs(system_path + '/CTCA/coverage_test/data/' + project_name, exist_ok=True)
     # 打开文件
    with open(system_path + '/CTCA/coverage_test/data/' + project_name + '/operational_code_snippet_coverage2.csv', 'a', newline='') as file:
        if result:
            # 要写入的数据
            data_to_append = [f'test_{id}'] + coverage + count_lines_and_length(maven_project_path + '/src/test/java/net/mooctest/' + project_name.split('_')[0] + '_Test.java')
        else:
            data_to_append = [f'test_{id}', 'Maven project build failed.','',''] + count_lines_and_length(maven_project_path + '/src/test/java/net/mooctest/' + project_name.split('_')[0] + '_Test.java')
        
        writer = csv.writer(file)
        # 追加写入数据
        writer.writerow(data_to_append)

    os.remove(maven_project_path + '/src/test/java/net/mooctest/' + project_name.split('_')[0] + '_Test.java')

    # 清除构建过程中创建的文件
    clean_directory(maven_project_path)

    user = "lcd"
    keyword = "java"
    kill_processes(user, keyword)
    
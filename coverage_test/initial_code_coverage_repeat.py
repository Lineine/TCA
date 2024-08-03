import multiprocessing
import shutil
import subprocess
import pandas as pd
from collections import defaultdict
import os
import csv

import psutil

def validate_maven_project(project_path, file_path):
    try:
        for root, dirs, files in os.walk(file_path):
            for file in files:
                source_path = os.path.join(root, file)
                
                # 构造目标路径
                destination_path = os.path.join(project_path + '/src/test/java/net/mooctest', file)

                # 复制文件
                shutil.copy(source_path, destination_path)        

        # 使用 Maven 构建项目 windows使用['mvn', 'clean', 'install']
        build_process = subprocess.run(['mvn clean install'], cwd=project_path, capture_output=True, text=True, shell=True)

        # 如果构建成功，返回 True
        if build_process.returncode == 0:
            return True
        else:
            # 如果构建失败，打印错误信息并返回 False
            print("Build error:", build_process.stderr)
            return False
    except Exception as e:
        print(e)
        return False
    finally:
        for root, dirs, files in os.walk(file_path):
            for file in files:
                file_path = os.path.join(project_path + '/src/test/java/net/mooctest', file)
                os.remove(file_path)

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

# 指定未分割前的代码文件所在路径
folder_path = system_path + '/CTCA/data/last_data/' + project_name + '/first_code'

# 读取CSV文件
file_path = system_path + '/CTCA/coverage_test/data/' + project_name + '/initial_code_coverage.csv'

# 读取CSV文件
with open(file_path, newline='') as csvfile:
    reader = csv.reader(csvfile)
    rows = list(reader)

# 处理每一行数据
for i, row in enumerate(rows):
    if row[1] == 'Maven project build failed.' or row[3] == '0.0':
        for _ in range(5):
            maven_file_path = os.path.join(folder_path, row[0])
            print(maven_file_path)
        
            # 调用编译和运行函数
            pool = multiprocessing.Pool(processes=1)
            result = pool.apply_async(validate_maven_project, (maven_project_path, maven_file_path))
            timeout = 100
            try:
                # 在设置的超时时间内获取结果
                result = result.get(timeout=timeout)
            except multiprocessing.TimeoutError:
                # 如果在超时时间内未获取到结果，则终止进程并抛出异常
                pool.terminate()
                result = 0

            coverage = 0

            jacoco_path = maven_project_path + '/target/site/jacoco/jacoco.csv'
            if not os.path.exists(jacoco_path):
                result = False

            # 打印结果
            if result:
                coverage = read_coverage(jacoco_path)
                rows[i] = [row[0]] + coverage + count_lines_and_length(maven_file_path)
                print("Maven project can be built.")
                if rows[i][1] != 0:
                    break
            else:
                print("Maven project build failed.")

            # 清除构建过程中创建的文件
            clean_directory(maven_project_path)

            user = "lcd"
            keyword = "java"
            kill_processes(user, keyword)

# 将修改后的内容写回CSV文件
with open(file_path, 'w', newline='') as csvfile:
    writer = csv.writer(csvfile)
    writer.writerows(rows)


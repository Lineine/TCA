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

def count_files_recursively(directory_path):
    try:
        # 初始化文件计数器
        file_count = 0

        # 使用 os.walk 遍历目录及其子目录
        for _, _, files in os.walk(directory_path):
            # 增加文件计数
            file_count += len(files)

        # 返回文件数量
        return file_count

    except FileNotFoundError:
        print(f"The directory {directory_path} does not exist.")
        return None

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


# 遍历文件夹下的所有文件
for id in trange(20, 40):

    file_path = os.path.join(folder_path, f'test_{id}.txt')
    print("Processing:", file_path)

    with open(system_path + '/CTCA/data/last_data/' + project_name + "/slicing_import/" + os.path.basename(file_path), 'r') as file:

        import_code = file.read()

    with open(system_path + '/CTCA/data/last_data/' + project_name + "/slicing_extract/" + os.path.basename(file_path), 'r') as file:

        extract_code = file.read()
    id = count_files_recursively(maven_project_path + '/src/test/java/net/mooctest/')
    # 在这里可以添加你对 txt 文件的处理逻辑
    # 例如读取文件内容、进行文本分析等
    with open(file_path, 'r', encoding='utf-8') as file:

        # java_code = import_code + 'public class ' + project_name + '_Test {\n' + extract_code + '\n' + file.read() + '\n}'
        java_code = import_code + 'public class ' + project_name + f'{id}_Test' + ' {\n' + file.read() + '\n}'
        # 将 Java 代码写入临时文件
        with open(maven_project_path + '/src/test/java/net/mooctest/' + project_name + f'{id}_Test.java', 'w') as file:
            file.write(java_code)
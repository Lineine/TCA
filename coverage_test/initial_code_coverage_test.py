from collections import defaultdict
import multiprocessing
import pickle
import re
import subprocess
import os
import shutil
import pandas as pd
import csv
import psutil
from tqdm import trange
from tenacity import retry


@retry
def validate_maven_project(project_path, file_path):
    try:
        for root, dirs, files in os.walk(file_path):
            for file in files:
                source_path = os.path.join(root, file)
                
                
                destination_path = os.path.join(project_path + '/src/test/java/net/mooctest', file)

                
                shutil.copy(source_path, destination_path)        

        
        build_process = subprocess.run(['mvn clean install'], cwd=project_path, capture_output=True, text=True, shell=True)

        
        if build_process.returncode == 0:
            return True
        else:
            
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
    
    pattern_all_missed = r"All (\d+) branches missed."
    match_all_missed = re.match(pattern_all_missed, title_content)
    if match_all_missed:
        num = int(match_all_missed.group(1))
        return [0, num]

    
    pattern_all_covered = r"All (\d+) branches covered."
    match_all_covered = re.match(pattern_all_covered, title_content)
    if match_all_covered:
        num = int(match_all_covered.group(1))
        return [num, num]

    
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
                class_name = file.split('.')[0] 
                with open(file_path, "r", encoding="utf-8") as file:
                    html_content = file.readlines()[1:]
                
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
    
    df = pd.read_csv(file_path)

    
    if 'INSTRUCTION_COVERED' in df.columns and 'BRANCH_COVERED' in df.columns:
        
        BRANCH_COVERED = df['BRANCH_COVERED'].sum()
        INSTRUCTION_COVERED = df['INSTRUCTION_COVERED'].sum()
        BRANCH_MISSED = df['BRANCH_MISSED'].sum()
        INSTRUCTION_MISSED = df['INSTRUCTION_MISSED'].sum()
        branch_coverage = BRANCH_COVERED/(BRANCH_COVERED + BRANCH_MISSED) if (BRANCH_COVERED + BRANCH_MISSED) > 0 else 0
        instruction_coverage = INSTRUCTION_COVERED/(INSTRUCTION_COVERED + INSTRUCTION_MISSED)  if (INSTRUCTION_COVERED + INSTRUCTION_MISSED) > 0 else 0
        coverage = branch_coverage/2 + instruction_coverage/2
        
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

    
    for root, dirs, files in os.walk(directory):
        for file in files:
            
            if file.endswith('.java'):
                file_path = os.path.join(root, file)
                with open(file_path, 'r', encoding='utf-8') as f:
                    
                    lines = f.readlines()
                    total_lines += len(lines)
                    total_length += sum(len(line) for line in lines)

    return [total_lines, total_length]

@retry
def clean_directory(path):
    
    files_and_folders = os.listdir(path)
    
    for item in files_and_folders:
        item_path = os.path.join(path, item)
        
        
        if os.path.isdir(item_path):
            if item not in ['src', 'target']:
                clean_directory(item_path)
        
        else:
            if item not in ['pom.xml', 'test_operational.iml']:
                os.remove(item_path)

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

    
    for filename in os.listdir(folder_path):
        if filename.endswith('.pkl'):
            file_path = os.path.join(folder_path, filename)
            with open(file_path, 'rb') as f:
                data = pickle.load(f)
                
                for key, value in data.items():
                    if key in merged_dict:
                        
                        merged_dict[key][0] = max(merged_dict[key][0], value[0])
                        merged_dict[key][1] = max(merged_dict[key][1], value[1])
                    else:
                        
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
    maven_project_path = system_path + '/TCA/coverage_test/test_main/'  + project_name + '/test_operational'
else:
    maven_project_path = system_path + '/TCA/coverage_test/test_main/'  + project_name.split('_')[0] + '/test_operational'


os.makedirs(system_path + '/TCA/coverage_test/data/' + project_name, exist_ok=True)
os.makedirs(system_path + '/TCA/coverage_test/data/' + project_name + '/branch_point', exist_ok=True)


folder_path = system_path + '/TCA/data/last_data/' + project_name + '/first_code'

test_ids = get_test_ids(folder_path)


for i in trange(0, len(test_ids)):
    print(i)
    id = test_ids[i]
    file_path = os.path.join(folder_path, f'test_{id}')
    print(file_path)

    
    pool = multiprocessing.Pool(processes=1)
    result = pool.apply_async(validate_maven_project, (maven_project_path, file_path))
    timeout = 100
    try:
        
        result = result.get(timeout=timeout)
    except multiprocessing.TimeoutError:
        
        pool.terminate()
        result = 0
        print("TimeOut!")

    coverage = 0

    jacoco_path = maven_project_path + '/target/site/jacoco/jacoco.csv'
    if not os.path.exists(jacoco_path):
        result = False

    
    if result:
        coverage = read_coverage(jacoco_path)
        
        
        with open(system_path + '/TCA/coverage_test/data/' + project_name + f'/branch_point/test_{id}.pkl', 'wb') as file:
            classname_to_bc_point = read_coverage_point(maven_project_path + '/target/site/jacoco/net.mooctest')
            pickle.dump(classname_to_bc_point, file)
        
        print("Maven project can be built.")
    else:
        print("Maven project build failed.")
    
    
    with open(system_path + '/TCA/coverage_test/data/' + project_name + '/initial_code_coverage.csv', 'a', newline='') as file:
        if result:
            
            data_to_append = [f'test_{id}'] + coverage + count_lines_and_length(file_path)
        else:
            data_to_append = [f'test_{id}', 'Maven project build failed.']

        writer = csv.writer(file)
        
        writer.writerow(data_to_append)

    
    clean_directory(maven_project_path)

    user = "lcd"
    keyword = "java"
    kill_processes(user, keyword)

folder_path = system_path + '/TCA/coverage_test/data/' + project_name + '/branch_point'
merged_dict = merge_dicts_in_folder(folder_path)
with open(system_path + '/TCA/coverage_test/data/' + project_name + '/branch_point/test_total.pkl', 'wb') as file:
    pickle.dump(merged_dict, file)


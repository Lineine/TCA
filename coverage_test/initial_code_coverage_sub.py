import multiprocessing
import pickle
import subprocess
import os
import shutil
import pandas as pd
import csv
import psutil
from tqdm import trange

def get_test_ids(directory):
    test_ids = []
    for root, dirs, files in os.walk(directory):
        for dir_name in dirs:
            if dir_name.startswith('test_'):
                test_ids.append(int(dir_name.split('_')[1]))
    return sorted(test_ids)

def csv_to_dict(filename):
    result_dict = {}
    with open(filename, 'r', encoding='utf-8') as file:
        reader = csv.reader(file)
        for row in reader:
            key = row[0]
            value = row[1:]
            result_dict[key] = value
    return result_dict

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

csv_filename = system_path + '/CTCA/coverage_test/data/' + project_name.split('_')[0] + '/initial_code_coverage.csv'
result = csv_to_dict(csv_filename)

# 遍历文件夹下的所有文件
for i in trange(0, len(test_ids)):
    # print(i)
    id = test_ids[i]
    file_path = os.path.join(folder_path, f'test_{id}')
    # print(file_path)
    source_path = system_path + '/CTCA/coverage_test/data/' + project_name.split('_')[0] + f'/branch_point/test_{id}.pkl'
    destination_path = system_path + '/CTCA/coverage_test/data/' + project_name + f'/branch_point/test_{id}.pkl'
    if os.path.exists(source_path):
        shutil.copyfile(source_path, destination_path)

    # 打开文件，如果不存在则创建
    with open(system_path + '/CTCA/coverage_test/data/' + project_name + '/initial_code_coverage.csv', 'a', newline='') as file:
        # 要写入的数据
        data_to_append = [f'test_{id}'] + result[f'test_{id}']

        writer = csv.writer(file)
        # 追加写入数据
        writer.writerow(data_to_append)

folder_path = system_path + '/CTCA/coverage_test/data/' + project_name + '/branch_point'
merged_dict = merge_dicts_in_folder(folder_path)
with open(system_path + '/CTCA/coverage_test/data/' + project_name + '/branch_point/test_total.pkl', 'wb') as file:
    pickle.dump(merged_dict, file)
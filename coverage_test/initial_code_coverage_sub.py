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

csv_filename = system_path + '/TCA/coverage_test/data/' + project_name.split('_')[0] + '/initial_code_coverage.csv'
result = csv_to_dict(csv_filename)


for i in trange(0, len(test_ids)):
    
    id = test_ids[i]
    file_path = os.path.join(folder_path, f'test_{id}')
    
    source_path = system_path + '/TCA/coverage_test/data/' + project_name.split('_')[0] + f'/branch_point/test_{id}.pkl'
    destination_path = system_path + '/TCA/coverage_test/data/' + project_name + f'/branch_point/test_{id}.pkl'
    if os.path.exists(source_path):
        shutil.copyfile(source_path, destination_path)

    
    with open(system_path + '/TCA/coverage_test/data/' + project_name + '/initial_code_coverage.csv', 'a', newline='') as file:
        
        data_to_append = [f'test_{id}'] + result[f'test_{id}']

        writer = csv.writer(file)
        
        writer.writerow(data_to_append)

folder_path = system_path + '/TCA/coverage_test/data/' + project_name + '/branch_point'
merged_dict = merge_dicts_in_folder(folder_path)
with open(system_path + '/TCA/coverage_test/data/' + project_name + '/branch_point/test_total.pkl', 'wb') as file:
    pickle.dump(merged_dict, file)
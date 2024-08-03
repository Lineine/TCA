import os
import csv
import shutil

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

def get_top_percent_element(lst, p):
    sorted_lst = sorted(lst, reverse=True)  
    ten_percent_index = int(len(sorted_lst) * p / 100)  
    top_percent_element = sorted_lst[ten_percent_index]  
    return top_percent_element

percent = 15

source_folder = system_path + '/CTCA/data/last_data/' + project_name + '/first_code'
folder_path = system_path + '/CTCA/data/last_data/' + project_name + '_sub_' + str(percent) + '/first_code'
csv_path = system_path + '/CTCA/coverage_test/data/' + project_name + '/initial_code_coverage.csv'

if not os.path.exists(folder_path):
    os.makedirs(folder_path)

for root, dirs, files in os.walk(source_folder):
    for folder in dirs:
        source_path = os.path.join(root, folder)
        destination_path = os.path.join(folder_path, os.path.relpath(source_path, source_folder))
        shutil.copytree(source_path, destination_path)


with open(csv_path, 'r') as csvfile:
    reader = csv.reader(csvfile)
    values = []
    for row in reader:
        if row[1] == 'Maven project build failed.':
            values.append(0)
            continue
        folder_name = row[0]
        values.append(float(row[1]))

with open(csv_path, 'r') as csvfile:
    reader = csv.reader(csvfile)
    target = get_top_percent_element(values, percent)
    for row in reader:
        if row[1] == 'Maven project build failed.':
            continue
        folder_name = row[0]
        value = float(row[1])
        if value > target:  
            folder_to_delete = os.path.join(folder_path, folder_name)
            if os.path.exists(folder_to_delete) and os.path.isdir(folder_to_delete):
                shutil.rmtree(folder_to_delete)
                print(f"Deleted folder: {folder_to_delete}")
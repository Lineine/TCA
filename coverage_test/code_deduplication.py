from collections import defaultdict
import csv
import os


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

column_5_dict = defaultdict(set)
column_5_6_dict = defaultdict(set)

result_list = []

file_path = system_path + '/TCA/coverage_test/data/' + project_name + '/operational_code_snippet_coverage.csv'
with open(file_path, newline='') as csvfile:
    reader = csv.reader(csvfile)
    for row in reader:
        if row[1] == 'Maven project build failed.':
            result_list.append(row[0])
            continue
        column_5 = row[4]
        column_6 = row[5]
        column_4 = row[3]

        if column_5 in column_5_dict.keys() and \
            column_6 in column_5_dict[column_5] and \
            (column_5, column_6) in column_5_6_dict.keys() and \
            column_4 in column_5_6_dict[(column_5, column_6)] or column_4 == '0.0':
            result_list.append(row[0])

        column_5_dict[column_5].add(column_6)

        key = (column_5, column_6)
        column_5_6_dict[key].add(column_4)

print(result_list)

folder_path = system_path + '/TCA/data/last_data/' + project_name + '/operational_result'
for file_name in result_list:
    file_path = os.path.join(folder_path, file_name) + '.txt'
    try:
        if os.path.exists(file_path):
            os.remove(file_path)
    except Exception as e:
        print( f'fail {file_name}')
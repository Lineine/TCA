import pandas as pd
from collections import defaultdict
import os
import csv

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

file_path = system_path + '/TCA/coverage_test/data/' + project_name + '/initial_code_coverage.csv'
count_row = 0

with open(file_path, newline='') as csvfile:
    reader = csv.reader(csvfile)
    branch_coverage_distribution = {i: [] for i in range(0, 10)}
    statement_coverage_distribution = {i: [] for i in range(0, 10)}

    for row in reader:
        if row[1] == 'Maven project build failed.':
            continue
        count_row += 1
        value1 = float(row[1])
        value2 = float(row[2])
        
        category1 = int((value1 * 100 - 0.000001) / 10)
        category2 = int((value2 * 100 - 0.000001) / 10)

        branch_coverage_distribution[category1].append(row[0] + ':' + str(round(value1, 5)))
        statement_coverage_distribution[category2].append(row[0] + ':' + str(round(value2, 5)))

for key, lst in branch_coverage_distribution.items():
    branch_coverage_distribution[key] = sorted(lst, key=lambda x:x.split(':')[1])

for key, lst in statement_coverage_distribution.items():
    statement_coverage_distribution[key] = sorted(lst, key=lambda x:x.split(':')[1])

for key, value in branch_coverage_distribution.items():
    print(f"Category {key}: {value}")

for key, value in statement_coverage_distribution.items():
    print(f"Category {key}: {value}")


file_path = system_path + '/TCA/coverage_test/data/' + project_name + '/coverage_distribution.csv'


with open(file_path, 'w', newline='') as csvfile:
    writer = csv.writer(csvfile)
    
    
    writer.writerow(["branch_coverage_distribution:"])

    writer.writerow(["branch_coverage", "number", "number of all"] + [f"value_{i+1}" for i in range(max(len(value) for value in branch_coverage_distribution.values()))])
    
    
    for key, value in branch_coverage_distribution.items():
        row = [str(key*10) + '-' + str(key*10 + 10) + '%', len(value), len(value)/count_row] + value
        writer.writerow(row)

    
    writer.writerow(["statement_coverage_distribution:"])

    writer.writerow(["statement_coverage", "number", "number of all"] + [f"value_{i+1}" for i in range(max(len(value) for value in statement_coverage_distribution.values()))])

    for key, value in statement_coverage_distribution.items():
        row = [str(key*10) + '-' + str(key*10 + 10) + '%', len(value), len(value)/count_row] + value
        writer.writerow(row)
import csv
import os
import pickle
from collections import defaultdict
import matplotlib.pyplot as plt
from matplotlib_venn import venn2, venn2_circles


def merge_dicts(dicts):
    merged_dict = defaultdict(lambda: [0, 0])

    for d in dicts:
        for key, value in d.items():
            merged_dict[key] = [max(merged_dict[key][i], value[i]) for i in range(2)]
    
    return dict(merged_dict)

def find_keys_with_greater_first_element(dict_a, dict_b):
    greater_keys = []
    
    for key in dict_a:
        if key in dict_b and dict_a[key][0] > dict_b[key][0]:
            greater_keys.append([key, dict_a[key][0] - dict_b[key][0]])
    
    return greater_keys

def calculate_sums(data):
    first_element_sum = 0
    second_element_sum = 0
    
    for value in data.values():
        first_element_sum += value[0]
        second_element_sum += value[1]
    
    return first_element_sum, second_element_sum

def toVennData(data):
    set0 = set()
    for key in data.keys():
        for i in range(0, data[key][0]):
            set0.add(key[0] + key[1] + str(i))
    return set0
        

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
project_name = 'Anagram_sub_10'

file_path = system_path + '/TCA/coverage_test/data/' + project_name + '/initial_code_coverage.csv'
count_row = 0


with open(file_path, newline='') as csvfile:
    reader = csv.reader(csvfile)
    
    branch_coverage_distribution = []

    
    for row in reader:
        if row[1] == 'Maven project build failed.':
            continue
        count_row += 1
        
        value1 = float(row[1])

        
        branch_coverage_distribution.append([row[0].split('_')[1], value1])

branch_coverage_distribution = sorted(branch_coverage_distribution, key=lambda x: x[1])


dict_list = []

print(branch_coverage_distribution)
for i in range(0, 10):
    file_path = system_path + '/TCA/coverage_test/data/' + project_name + f'/branch_point/test_{branch_coverage_distribution[i][0]}.pkl'
    if os.path.exists(file_path):
        with open(file_path, 'rb') as file:
            dict_list.append(pickle.load(file))

merged_result = merge_dicts(dict_list)
print(merged_result)



file_path = system_path + '/TCA/coverage_test/data/' + project_name + f'/branch_point/test_{branch_coverage_distribution[-1][0]}.pkl'


with open(file_path, 'rb') as file:
    top = pickle.load(file)

print(top)


result = find_keys_with_greater_first_element(merged_result, top)
print(result)


set1 = toVennData(merged_result)
set2 = toVennData(top)


plt.figure(figsize=(8, 8))
venn = venn2([set1, set2], ('Set 1', 'Set 2'))


venn_circles = venn2_circles([set1, set2])


plt.title("Venn Diagram of Set 1 and Set 2")
plt.show()
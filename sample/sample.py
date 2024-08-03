from genericpath import exists
import pickle
import random
import numpy as np
import os
import re
import copy
import subprocess
import itertools
import csv
from concurrent.futures import ThreadPoolExecutor, as_completed
from collections import defaultdict
from copy import deepcopy
from tqdm import tqdm

def judge_same_import(str_list):
    last_XX_list = [item.split('.')[-1] for item in str_list]

    for i in range(len(last_XX_list)):
        for j in range(i+1, len(last_XX_list)):
            if last_XX_list[i] == last_XX_list[j] and str_list[i] != str_list[j]:
                return True
    
    return False

def get_file_count(folder_path):
    files = [file for file in os.listdir(folder_path) if os.path.isfile(os.path.join(folder_path, file))]
    return len(files)

def get_folder_count(folder_path):
    folder_count = 0

    for entry in os.scandir(folder_path):
        if entry.is_dir():
            folder_count += 1

    return folder_count

def java_format(java_code):
    lines = java_code.strip().split('\n')

    indent_level = 0

    formatted_code = []
    for line in lines:
        line = line.strip()
        if '}' in line:
            indent_level -= 1
        formatted_line = '    ' * indent_level + line
        formatted_code.append(formatted_line)
        if '{' in line:
            indent_level += 1

    formatted_java_code = '\n'.join(formatted_code)

    return formatted_java_code

def pagerank(similarity_matrix, damping_factor=0.85, max_iterations=100, epsilon=1.0e-8):
    similarity_matrix = np.array(similarity_matrix)

    transition_matrix = similarity_matrix / similarity_matrix.sum(axis=1, keepdims=True)

    num_pages = transition_matrix.shape[0]
    pagerank_vector = np.ones(num_pages) / num_pages

    for _ in range(max_iterations):
        new_pagerank_vector = (1 - damping_factor) / num_pages + damping_factor * np.dot(transition_matrix.T, pagerank_vector)
        
        if np.linalg.norm(new_pagerank_vector - pagerank_vector) < epsilon:
            break
        
        pagerank_vector = new_pagerank_vector

    return pagerank_vector

def pagerank_select(id_list, id_content_dict, select_number, file_path):

    with open(file_path, 'rb') as file:
        similarity_matrix = pickle.load(file)

    index_to_id = list(id_content_dict.keys())
    id_to_index = {int(index_to_id[i]): i for i in range(len(index_to_id))}
    sub_similarity_matrix = np.array([[similarity_matrix[id_to_index[int(id_i)]][id_to_index[int(id_j)]] for id_j in id_list] for id_i in id_list])

    pr_values = pagerank(sub_similarity_matrix)
    '''
    # 打印结果
    for i, pr_value in enumerate(sorted(pr_values, reverse=True)):
        if i > 10:
            break
        print(f"Vector {i+1}: PageRank = {pr_value:.4f}")
    '''
    indexed_lst = list(enumerate(pr_values))  
    sorted_indices = sorted(indexed_lst, key=lambda x: x[1], reverse=True)  
    top_n_indices = [index for index, _ in sorted_indices[:select_number]]  

    return [id_list[i] for i in top_n_indices]

def delete_folder_contents(folder_path):
    for root, dirs, files in os.walk(folder_path, topdown=False):
        for name in files:
            file_path = os.path.join(root, name)
            try:
                os.remove(file_path)
                print("Deleted file:", file_path)
            except Exception as e:
                print("Error deleting file:", file_path, e)
        
        for name in dirs:
            dir_path = os.path.join(root, name)
            try:
                os.rmdir(dir_path)
                print("Deleted directory:", dir_path)
            except Exception as e:
                print("Error deleting directory:", dir_path, e)


def adaptive_sampling(clustered_list, total_samples):

    list_length = len(clustered_list)

    sampling_rate = min(1.0, total_samples / list_length)

    sampled_elements = set()

    while len(sampled_elements) < total_samples:
        for cluster in clustered_list:
            if random.random() < sampling_rate:
                sampled_element = random.choice(cluster)
                sampled_elements.add(sampled_element)
                if len(sampled_elements) == total_samples:
                    break

    return list(sampled_elements)             

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

os.makedirs(system_path + '/TCA/data/last_data/' + project_name + '/last_code', exist_ok=True)

# 'kmeans' 'HAC'
clustered_method = 'HAC'

n_clusters_values = [i for i in range(5, 101, 5)]

# 'PageRank' 'Random' 'loop_Random' 'loop_Length_First' 'Adaptive' 
# ['loop_Random', 'loop_Length_First', 'Adaptive', 'one_by_one']
sample_methods = ['Random']

# 'my_similarity_matrix' 'embedding_similarity_matrix'
pagerank_matrix_selected = 'embedding_similarity_matrix'

#[10, 50, 100, 150, 200, 300]
selected_num_values = [i for i in range(1, 300, 5)]

folder_path = system_path + '/TCA/data/last_data/' + project_name + '/operational_result'

id_content_dict = {}

for filename in tqdm(os.listdir(folder_path)):
    if filename.startswith('test_') and filename.endswith('.txt'):
        code_file_path = os.path.join(folder_path, filename)
        with open(code_file_path, 'r',  encoding='utf-8') as file:
            file_id = int(filename.split('_')[1].split('.')[0])
            id_content_dict[file_id] = file.read()

try:
    with open(system_path + '/TCA/sample/data/' + project_name + '/experiment_results.pkl', 'rb') as f:
        results = pickle.load(f)
except FileNotFoundError:
    results = {}
    if os.path.exists(system_path + '/TCA/coverage_test/data/' + project_name + '/coverage_t5_1.csv'):
        os.remove(system_path + '/TCA/coverage_test/data/' + project_name + '/coverage_t5_1.csv')


experiment_params = itertools.product(n_clusters_values, sample_methods)
for n_clusters, sample_method in tqdm(experiment_params):

    if (n_clusters, sample_method) in results:
        print(f"Skipping {n_clusters}, {sample_method} as it has been computed before")
        continue
    
    with open(system_path + '/TCA/coverage_test/data/' + project_name + '/coverage_t5_1.csv', 'a', newline='') as file:
        data_to_append = [n_clusters, sample_method]
        writer = csv.writer(file)
        writer.writerow(data_to_append)

    file_path = system_path + '/TCA/sample/data/' + project_name + '/codeT5_embeddings.pkl'

    with open(file_path, 'rb') as file:
        embeddings = pickle.load(file)

    file_path = system_path + '/TCA/sample/data/' + project_name + '/char_count.pkl'

    with open(file_path, 'rb') as file:
        char_count = pickle.load(file)

    file_path = system_path + '/TCA/sample/data/' + project_name + '/clustered_list_' + clustered_method + f'_{n_clusters}.pkl'
    with open(file_path, 'rb') as file:
        clustered_list = pickle.load(file)
    
    for selected_num in [n_clusters for _ in range(30)]:
        print('Number of clusters:', n_clusters)
        print('Sample method:', sample_method)
        print('Selected_num:', selected_num)

        if selected_num > len(embeddings):
            continue

        # for i, clusters in enumerate(clustered_list, 1):
        #     print(f"Cluster {i}: {clusters}")

        folder_path = system_path + '/TCA/data/last_data/' + project_name + '/last_code'
        
        delete_folder_contents(folder_path)

        file_path = system_path + '/TCA/sample/data/' + project_name + '/' + pagerank_matrix_selected + '.pkl'

        selected_ids = []
        if sample_method == 'PageRank':
            one_cluster_selected_num = selected_num // n_clusters
            for i, id_list in enumerate(clustered_list):
                select_number = min(len(id_list), one_cluster_selected_num)
                if pagerank_matrix_selected == 'embedding_similarity_matrix':
                    selected_ids.extend(pagerank_select(id_list, id_content_dict, select_number, file_path))
                elif pagerank_matrix_selected == 'my_similarity_matrix':
                    selected_ids.extend(pagerank_select(id_list, embeddings, select_number, file_path))

        elif sample_method == 'loop_Random':
            count = 0
            clustered_list_tmp = copy.deepcopy(clustered_list)
            while count < selected_num:
                for i, id_list in enumerate(clustered_list_tmp):
                    selected_index = random.randrange(len(id_list))
                    selected_ids.append(id_list[selected_index])
                    id_list.pop(selected_index)
                    count += 1

                    if len(id_list) == 0:
                        clustered_list_tmp.pop(i)
                    
                    if count >= selected_num:
                        break
        
        elif sample_method == 'loop_Length_First':
            clustered_list = [sorted(id_list, key=lambda x: char_count.get(x, 0), reverse=True) for id_list in clustered_list]
        
            count = 0
            clustered_list_tmp = copy.deepcopy(clustered_list)
            while count < selected_num:
                for i, id_list in enumerate(clustered_list_tmp):
                    selected_ids.append(id_list[0])
                    id_list.pop(0)
                    count += 1

                    if len(id_list) == 0:
                        clustered_list_tmp.pop(i)
                    
                    if count >= selected_num:
                        break

        elif sample_method == 'Adaptive':
            selected_ids = adaptive_sampling(clustered_list, selected_num)
        
        
        elif sample_method == 'Random':
            for i, id_list in enumerate(clustered_list):
                selected_t = random.sample(id_list, min(len(id_list), 1))
                selected_ids.extend(selected_t)
        

        selected_ids = np.array(selected_ids)

        directory_path = system_path + '/TCA/data/last_data/' + project_name + '/operational_result'
        import_path = system_path + '/TCA/data/last_data/' + project_name + '/slicing_import'
        extract_path = system_path + '/TCA/data/last_data/' + project_name + '/slicing_extract'

        all_java_codes = defaultdict(list)
        all_import_codes = defaultdict(list)
        all_extract_codes = defaultdict(list)
        for file_id in selected_ids:
            java_code = ''
            import_code = []
            filename = f'test_{file_id}.txt'
            
            file_path = os.path.join(directory_path, filename)
            file_import_path = os.path.join(import_path, filename)
            file_extract_path = os.path.join(extract_path, filename)

            if os.path.exists(file_path):
                with open(file_path, 'r', encoding='utf-8') as file:
                    java_code = file.read()
            else:
                print(f"{file_path} not found.")
            
            with open(file_import_path, 'r', encoding='utf-8') as import_file:
                for line in import_file:
                    import_code.append(line)
            
            with open(system_path + '/TCA/data/last_data/' + project_name + "/slicing_extract/" + os.path.basename(file_path), 'r') as file:
                extract_code = file.read()   
            
            if len(all_import_codes) == 0:
                all_import_codes[0].extend(import_code)
                all_java_codes[0].append(java_code)
                all_extract_codes[0].append(extract_code)
                continue
            
            if project_name == 'GTree' or project_name == 'ITree' or project_name.startswith('GTree') or project_name.startswith('ITree'):
                last_XX_list = [item.split('.')[-1].split(';')[0] for item in import_code]
                is_append = False
                if 'System' in last_XX_list:
                    for key in all_import_codes.keys():
                        tmp = deepcopy(all_import_codes[key])
                        last_XX_list = [item.split('.')[-1] for item in tmp]
                        if 'System' in last_XX_list:
                            all_import_codes[key].extend(import_code)
                            all_java_codes[key].append(java_code)
                            all_extract_codes[key].append(extract_code)
                            is_append = True
                            break
                else:
                    for key in all_import_codes.keys():
                        tmp = deepcopy(all_import_codes[key])
                        last_XX_list = [item.split('.')[-1].split(';')[0] for item in tmp]
                        if 'System' in last_XX_list:
                            continue 
                        tmp.extend(import_code)
                        tmp = list(set(tmp))
                        if not judge_same_import(tmp):
                            is_append = True
                            all_import_codes[key].extend(import_code)
                            all_java_codes[key].append(java_code)
                            all_extract_codes[key].append(extract_code)
                            break
                if not is_append:
                    all_import_codes[len(all_import_codes)].extend(import_code)
                    all_java_codes[len(all_java_codes)].append(java_code)
                    all_extract_codes[len(all_extract_codes)].append(extract_code)
                continue
            
            if project_name == 'UnrolledLinkedList2023' or project_name.startswith('UnrolledLinkedList2023'):
                last_XX_list = [item.split('.')[-1].split(';')[0] for item in import_code]
                is_append = False
                if 'String' in last_XX_list:
                    for key in all_import_codes.keys():
                        tmp = deepcopy(all_import_codes[key])
                        last_XX_list = [item.split('.')[-1] for item in tmp]
                        if 'String' in last_XX_list:
                            all_import_codes[key].extend(import_code)
                            all_java_codes[key].append(java_code)
                            all_extract_codes[key].append(extract_code)
                            is_append = True
                            break
                else:
                    for key in all_import_codes.keys():
                        tmp = deepcopy(all_import_codes[key])
                        last_XX_list = [item.split('.')[-1].split(';')[0] for item in tmp]
                        if 'String' in last_XX_list:
                            continue 
                        tmp.extend(import_code)
                        tmp = list(set(tmp))
                        if not judge_same_import(tmp):
                            is_append = True
                            all_import_codes[key].extend(import_code)
                            all_java_codes[key].append(java_code)
                            all_extract_codes[key].append(extract_code)
                            break
                if not is_append:
                    all_import_codes[len(all_import_codes)].extend(import_code)
                    all_java_codes[len(all_java_codes)].append(java_code)
                    all_extract_codes[len(all_extract_codes)].append(extract_code)
                continue
            
            if project_name == 'Othello' or project_name.startswith('Othello'):
                import_code = [item if 'java.awt.List;' not in item else '' for item in import_code]    

            is_append = False
            for key in all_import_codes.keys():
                tmp = deepcopy(all_import_codes[key])
                tmp.extend(import_code)
                tmp = list(set(tmp))
                tmpex = deepcopy(all_extract_codes[key])
                if not judge_same_import(tmp) and not (any("setUp()" in s for s in tmpex) and "setUp()" in extract_code) \
                                            and not (any("setup()" in s for s in tmpex) and "setup()" in extract_code) \
                                            and not (any("dictionary" in s for s in tmpex) and "dictionary" in extract_code) \
                                            and not (any("board" in s for s in tmpex) and "board" in extract_code):
                    is_append = True
                    all_import_codes[key].extend(import_code)
                    all_java_codes[key].append(java_code)
                    all_extract_codes[key].append(extract_code)
                    break
                if not judge_same_import(tmp) and extract_code in tmpex:
                    is_append = True
                    all_import_codes[key].extend(import_code)
                    all_java_codes[key].append(java_code)
                    all_extract_codes[key].append('')
                    break
            
            if not is_append:
                all_import_codes[len(all_import_codes)].extend(import_code)
                all_java_codes[len(all_java_codes)].append(java_code)
                all_extract_codes[len(all_extract_codes)].append(extract_code)


        folder_path = system_path + '/TCA/data/last_data/' + project_name + '/last_code'
        num_folders = get_folder_count(folder_path)
        new_folder_name = project_name + f"_{num_folders}"
        new_folder_path = os.path.join(folder_path, new_folder_name)
        os.makedirs(new_folder_path)

        for key in all_import_codes.keys():
            import_codes = set([item for item in all_import_codes[key]])
            java_codes = all_java_codes[key]
            extract_codes = set([re.sub(r'[\n\t]+', '\n', item) for item in list(filter(None, all_extract_codes[key]))])

            import_codes.discard('package net.mooctest;\n')
            java_import_code = 'package net.mooctest;\n' + ''.join(import_codes)
            java_extract_code = '\n'.join(extract_codes)

            num_files = get_file_count(new_folder_path)
            last_code = java_import_code + java_format('public class ' + project_name + f'_{num_files}_Test ' + '\n' + '{\n' + java_extract_code + '\n' + '\n'.join(java_codes) + '\n}')

            new_file_name = project_name + f"_{num_files}_Test.java"
            new_file_path = os.path.join(new_folder_path, new_file_name)

            with open(new_file_path, 'w', encoding='utf-8', newline='\r\n') as file:
                file.write(last_code)

            print(f"Created file: {new_file_path}")

        proc = subprocess.run(["python", system_path + '/TCA/coverage_test/coverage_test.py'])

        if proc.returncode is None:
            proc.subprocess.kill()

    results[(n_clusters, sample_method)] = 1

    with open(system_path + '/TCA/sample/data/' + project_name + '/experiment_results.pkl', 'wb') as f:
        pickle.dump(results, f)

if os.path.exists(system_path + '/TCA/sample/data/' + project_name + '/experiment_results.pkl'):
    os.remove(system_path + '/TCA/sample/data/' + project_name + '/experiment_results.pkl')
    print(f"File '{system_path + '/TCA/sample/data/' + project_name + '/experiment_results.pkl'}' has been deleted.")
else:
    print(f"File '{system_path + '/TCA/sample/data/' + project_name + '/experiment_results.pkl'}' does not exist.")
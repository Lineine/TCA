import re
import shutil
import javalang
import glob
import os
from tqdm import trange

def find_java_files(directory_path):
    for root, _, files in os.walk(directory_path):
        java_files = glob.glob(os.path.join(root, '*.java'))
        for java_file in java_files:
            yield java_file

def extract_no_test_import(java_code, import_statements):

    for import_statement in import_statements:
        
        java_code = java_code.replace(import_statement, "")

    
    test_method_pattern = re.compile(r'@Test(?:\(timeout = \d+\))?')
    

    
    test_method_matches = test_method_pattern.finditer(java_code)

    
    test_method_codes = []

    
    for match in test_method_matches:
        start_index = match.end()  
        start_index, end_index = find_matching_brace(java_code, start_index)

        if end_index != -1:
            test_method_codes.append(java_code[match.start():end_index + 1])
    
    for test_method in test_method_codes:
        
        java_code = java_code.replace(test_method, "")
    
    java_code = java_code.strip()
    lines = java_code.split('\n')[1:-1]
    lines[0] = lines[0] + '\t'
    result = '\n'.join(lines)
    return result.strip() 

def remove_annotation(java_code):
    right_ptr = 0
    in_string = False  

    while right_ptr < len(java_code):
        if java_code[right_ptr] == '"':  
            in_string = not in_string  
        if not in_string and right_ptr + 1 < len(java_code) and java_code[right_ptr:right_ptr + 2] == '//':
            t = java_code.find('\n', right_ptr) + 1
            java_code = java_code[:right_ptr] + java_code[t:]
            continue
        right_ptr += 1

    in_string = False
    right_ptr = 0

    while right_ptr < len(java_code):
        if java_code[right_ptr] == '"':  
            in_string = not in_string  
        if not in_string and right_ptr + 1 < len(java_code) and java_code[right_ptr:right_ptr + 2] == '/*':
            t = java_code.find('*/', right_ptr) + 2
            java_code = java_code[:right_ptr] + java_code[t:]
            continue
        right_ptr += 1
    
    return java_code

def extract_test_methods(java_code):

    
    test_method_pattern = re.compile(r'@Test(?:\(timeout = \d+\))?')
    

    
    test_method_matches = test_method_pattern.finditer(java_code)

    
    test_method_codes = []

    
    for match in test_method_matches:
        start_index = match.end()  
        start_index, end_index = find_matching_brace(java_code, start_index)

        if end_index != -1:
            test_method_codes.append(java_code[start_index:end_index])

    return test_method_codes

def extract_import_statements(java_code):
    
    pattern = re.compile(r'^\s*import\s+[^;\n\r]+;', re.MULTILINE)
    
    
    import_matches = pattern.findall(java_code)
    import_statements = ["package net.mooctest;"] + [statement.strip() for statement in import_matches]

    return import_statements

def find_matching_brace(text, start_index):
    while start_index < len(text):
        if text[start_index] == '{':
            start_index += 1
            break
        start_index += 1
    
    brace_count = 1
    index = start_index

    inside_quotes = False  
    while index < len(text):
        if text[index] == '"' and text[index - 1] != '\\':
            inside_quotes = not inside_quotes
        elif not inside_quotes:
            if text[index] == '{':
                brace_count += 1
            elif text[index] == '}':
                brace_count -= 1

            if brace_count == 0:
                return start_index, index

        index += 1

    return -1, -1

def split_and_merge_java_code(java_code):
    
    left_ptr = 0
    right_ptr = 0

    
    merged_blocks = []
    while right_ptr < len(java_code):
        
        
        if java_code[right_ptr] == ';' and java_code[left_ptr:right_ptr].count('"')%2 != 1 and 'for' not in re.findall(r'\b\w+\b', java_code[left_ptr:right_ptr]) \
                and 'while' not in re.findall(r'\b\w+\b', java_code[left_ptr:right_ptr]) \
                and 'try' not in re.findall(r'\b\w+\b', java_code[left_ptr:right_ptr]) \
                and 'new Runnable()' not in java_code[left_ptr:right_ptr]:
            merged_blocks.append(java_code[left_ptr:right_ptr + 1].strip())
            left_ptr = right_ptr + 1
        
        elif java_code[right_ptr] == ';' and java_code[left_ptr:right_ptr].count('"')%2 != 1 and ('for' in re.findall(r'\b\w+\b', java_code[left_ptr:right_ptr]) or
                                             'while' in re.findall(r'\b\w+\b', java_code[left_ptr:right_ptr]) or
                                             'try' in re.findall(r'\b\w+\b', java_code[left_ptr:right_ptr]) or
                                             'new Runnable()' in java_code[left_ptr:right_ptr]):
            
            if 'for' in re.findall(r'\b\w+\b', java_code[left_ptr:right_ptr]) or 'while' in re.findall(r'\b\w+\b', java_code[left_ptr:right_ptr]):
                t = left_ptr
                jud = False
                while t < len(java_code):
                    if java_code[t] == ';':
                        t += 1
                        break
                    if java_code[t] == '{':
                        jud = True
                        break
                    t += 1
                if jud:
                    _, right_ptr = find_matching_brace(java_code, left_ptr)
                else:
                    right_ptr = t
            elif 'new Runnable()' in java_code[left_ptr:right_ptr]:
                _, right_ptr = find_matching_brace(java_code, left_ptr)
                right_ptr += 1
            elif 'try' in re.findall(r'\b\w+\b', java_code[left_ptr:right_ptr]):
                _, right_ptr = find_matching_brace(java_code, left_ptr)
                
                _, right_ptr = find_matching_brace(java_code, right_ptr)
            
            merged_blocks.append(java_code[left_ptr:right_ptr + 1].strip())
            
            if 'new Runnable()' in java_code[left_ptr:right_ptr]:
                if merged_blocks[-1][-1] != ';':
                    merged_blocks[-1] += ';'
            left_ptr = right_ptr + 1
        right_ptr += 1
        

    return merged_blocks

def is_variable_definition(statement):
    
    try:
        tokens = javalang.tokenizer.tokenize(statement)
        parser = javalang.parser.Parser(tokens)
        tree = parser.parse_member_declaration()
        
        for path, node in tree.filter(javalang.tree.VariableDeclarator):
            return True, node.name
        
    except Exception:
        return False, None

    return False, None

def split_java_code(java_code_list):
    code_blocks = []
    variable_names = {}

    for i, java_code in enumerate(java_code_list):
        
        is_definition, variable_name = is_variable_definition(java_code)

        
        variable_exists = any(variable_names[key] >= i for key in variable_names.keys())

        if not variable_exists:
            code_blocks.append([])
            variable_names.clear()

        if is_definition:
            last_index = None
            for i in range(len(java_code_list) - 1, -1, -1):
                statement = java_code_list[i]
                
                words_in_statement = re.findall(r'\b\w+\b', statement)
                if variable_name in words_in_statement:
                    last_index = i
                    break
            variable_names[variable_name] = last_index

        code_blocks[-1].append(java_code)

    return code_blocks

def count_files_recursively(directory_path):
    try:
        
        file_count = 0

        
        for _, _, files in os.walk(directory_path):
            
            file_count += len(files)

        
        return file_count

    except FileNotFoundError:
        print(f"The directory {directory_path} does not exist.")
        return None
    
def get_test_ids(parent_directory):
    
    subfolders = [f.name for f in os.scandir(parent_directory) if f.is_dir()]
    
    
    test_ids = [folder_name.split('_')[1] for folder_name in subfolders]
    
    return test_ids

file_path = os.path.abspath(os.path.join(os.path.dirname(__file__), "../globals.py"))
with open(file_path, 'r') as file:
    for line in file:
        
        if line.strip() and not line.strip().startswith('
            if 'SYSTEM_PATH =' in line:
                _, system_path = map(str.strip, line.split('='))
                system_path = system_path.strip("'")
            elif 'PROJECT_NAME =' in line:
                _, project_name = map(str.strip, line.split('='))
                project_name = project_name.strip("'")
                break  

print("SYSTEM_PATH:", system_path)
print("PROJECT_NAME:", project_name)    

folder_path = system_path + '/TCA/data/last_data/' + project_name + '/first_code'
if os.path.exists(system_path + '/TCA/data/last_data/' + project_name + '/slicing_result'):
    shutil.rmtree(system_path + '/TCA/data/last_data/' + project_name + '/slicing_result')
if os.path.exists(system_path + '/TCA/data/last_data/' + project_name + '/slicing_import'):
    shutil.rmtree(system_path + '/TCA/data/last_data/' + project_name + '/slicing_import')
if os.path.exists(system_path + '/TCA/data/last_data/' + project_name + '/slicing_extract'):
    shutil.rmtree(system_path + '/TCA/data/last_data/' + project_name + '/slicing_extract')
os.makedirs(system_path + '/TCA/data/last_data/' + project_name + '/slicing_result', exist_ok=True)
os.makedirs(system_path + '/TCA/data/last_data/' + project_name + '/slicing_import', exist_ok=True)
os.makedirs(system_path + '/TCA/data/last_data/' + project_name + '/slicing_extract', exist_ok=True)


for id in get_test_ids(folder_path):
    file_path = os.path.join(folder_path, f'test_{id}')

    
    java_files_path = list(find_java_files(file_path))

    for java_file_path in java_files_path:
        print(java_file_path)
        
        try:
            with open(java_file_path, 'r', encoding='utf-8') as file:
                java_code = file.read()
        except FileNotFoundError:
            print(f"The file '{java_file_path}' does not exist.")
        except Exception as e:
            print(f"An error occurred: {e}")

        java_code = remove_annotation(java_code)

        
        methods = extract_test_methods(java_code)

        
        import_statements = extract_import_statements(java_code)

        extract_code = extract_no_test_import(java_code, import_statements)
        
        
        
        
        new_method_number = count_files_recursively(system_path + '/TCA/data/last_data/' + project_name + '/slicing_result')

        new_methods = []
        for i, method_code in enumerate(methods, 1):
            print(f"Method {i}")
            java_statements = split_and_merge_java_code(method_code)

            result = split_java_code(java_statements)
            for i, block in enumerate(result, 1):
                new_methods.append(f"@Test\n" + f"public void test_{new_method_number}() throws Exception {{\n" + f'\n'.join(block) + f"\n}}")
                new_method_number += 1
        
        for method in new_methods:
            # print(method)
            pattern = re.compile(r'public\svoid\stest_(\d+)')
            id = int(pattern.findall(method)[0])
            with open(system_path + '/TCA/data/last_data/' + project_name + f'/slicing_result/test_{id}.txt', 'w') as file:
          
                file.write(method)
            with open(system_path + '/TCA/data/last_data/' + project_name + f'/slicing_import/test_{id}.txt', 'w') as file:
          
                for import_statement in import_statements:
                    file.write("%s\n" % import_statement)
            with open(system_path + '/TCA/data/last_data/' + project_name + f'/slicing_extract/test_{id}.txt', 'w') as file:
             
                file.write(extract_code)
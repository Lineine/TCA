import re
import shutil
import javalang
import glob
import os
from tqdm import trange

def find_java_files(directory_path):
    # 使用 os.walk 遍历目录及其子目录
    for root, _, files in os.walk(directory_path):
        # 使用 glob.glob 筛选出 Java 文件
        java_files = glob.glob(os.path.join(root, '*.java'))
        for java_file in java_files:
            yield java_file

def extract_no_test_import(java_code, import_statements):

    for import_statement in import_statements:
        # Replace all occurrences of the current string with an empty string
        java_code = java_code.replace(import_statement, "")

    # 使用正则表达式匹配带有@Test注解的方法
    test_method_pattern = re.compile(r'@Test(?:\(timeout = \d+\))?')
    # re.compile(r'public(?!\s*class\b)')

    # 查找所有匹配的@Test注解的方法
    test_method_matches = test_method_pattern.finditer(java_code)

    # 存储每个@Test注解的方法的代码
    test_method_codes = []

    # 提取每个@Test注解的方法的代码
    for match in test_method_matches:
        start_index = match.end()  # 获取@Test注解结束的位置
        start_index, end_index = find_matching_brace(java_code, start_index)

        if end_index != -1:
            test_method_codes.append(java_code[match.start():end_index + 1])
    
    for test_method in test_method_codes:
        # Replace all occurrences of the current string with an empty string
        java_code = java_code.replace(test_method, "")
    
    java_code = java_code.strip()
    lines = java_code.split('\n')[1:-1]
    lines[0] = lines[0] + '\t'
    result = '\n'.join(lines)
    return result.strip() 

def remove_annotation(java_code):
    right_ptr = 0
    in_string = False  # 用于跟踪是否在字符串内部

    while right_ptr < len(java_code):
        if java_code[right_ptr] == '"':  # 如果遇到双引号
            in_string = not in_string  # 切换状态
        if not in_string and right_ptr + 1 < len(java_code) and java_code[right_ptr:right_ptr + 2] == '//':
            t = java_code.find('\n', right_ptr) + 1
            java_code = java_code[:right_ptr] + java_code[t:]
            continue
        right_ptr += 1

    in_string = False
    right_ptr = 0

    while right_ptr < len(java_code):
        if java_code[right_ptr] == '"':  # 如果遇到双引号
            in_string = not in_string  # 切换状态
        if not in_string and right_ptr + 1 < len(java_code) and java_code[right_ptr:right_ptr + 2] == '/*':
            t = java_code.find('*/', right_ptr) + 2
            java_code = java_code[:right_ptr] + java_code[t:]
            continue
        right_ptr += 1
    
    return java_code

def extract_test_methods(java_code):

    # 使用正则表达式匹配带有@Test注解的方法
    test_method_pattern = re.compile(r'@Test(?:\(timeout = \d+\))?')
    # re.compile(r'public(?!\s*class\b)')

    # 查找所有匹配的@Test注解的方法
    test_method_matches = test_method_pattern.finditer(java_code)

    # 存储每个@Test注解的方法的代码
    test_method_codes = []

    # 提取每个@Test注解的方法的代码
    for match in test_method_matches:
        start_index = match.end()  # 获取@Test注解结束的位置
        start_index, end_index = find_matching_brace(java_code, start_index)

        if end_index != -1:
            test_method_codes.append(java_code[start_index:end_index])

    return test_method_codes

def extract_import_statements(java_code):
    # 正则表达式模式，匹配 import 语句
    pattern = re.compile(r'^\s*import\s+[^;\n\r]+;', re.MULTILINE)
    
    # 查找匹配的 import 语句
    import_matches = pattern.findall(java_code)
    import_statements = ["package net.mooctest;"] + [statement.strip() for statement in import_matches]

    return import_statements

def find_matching_brace(text, start_index):
    while start_index < len(text):
        if text[start_index] == '{':
            start_index += 1
            break
        start_index += 1
    # 寻找匹配的右大括号 '}' 的位置
    brace_count = 1
    index = start_index

    inside_quotes = False  # 用于跟踪是否在双引号内
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
    # 初始化左右指针
    left_ptr = 0
    right_ptr = 0

    # 存储合并后的代码块
    merged_blocks = []
    while right_ptr < len(java_code):
        # print(java_code[:right_ptr])
        # 如果没有遇到 for、while 和 try，右指针停在第一个分号处
        if java_code[right_ptr] == ';' and java_code[left_ptr:right_ptr].count('"')%2 != 1 and 'for' not in re.findall(r'\b\w+\b', java_code[left_ptr:right_ptr]) \
                and 'while' not in re.findall(r'\b\w+\b', java_code[left_ptr:right_ptr]) \
                and 'try' not in re.findall(r'\b\w+\b', java_code[left_ptr:right_ptr]) \
                and 'new Runnable()' not in java_code[left_ptr:right_ptr]:
            merged_blocks.append(java_code[left_ptr:right_ptr + 1].strip())
            left_ptr = right_ptr + 1
        # 如果遇到 for、while 或 try，右指针移到下一个匹配的大括号
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
                # 对于 try，找到与其匹配的 catch 语句的下一个大括号
                _, right_ptr = find_matching_brace(java_code, right_ptr)
            
            merged_blocks.append(java_code[left_ptr:right_ptr + 1].strip())
            #print(left_ptr,right_ptr)
            if 'new Runnable()' in java_code[left_ptr:right_ptr]:
                if merged_blocks[-1][-1] != ';':
                    merged_blocks[-1] += ';'
            left_ptr = right_ptr + 1
        right_ptr += 1
        # print(merged_blocks[-1] if len(merged_blocks) > 0 else 0)

    return merged_blocks

def is_variable_definition(statement):
    # print(statement)
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
        # print(java_code)
        is_definition, variable_name = is_variable_definition(java_code)

        # 检查当前变量是否在后续的代码中出现
        variable_exists = any(variable_names[key] >= i for key in variable_names.keys())

        if not variable_exists:
            code_blocks.append([])
            variable_names.clear()

        if is_definition:
            last_index = None
            for i in range(len(java_code_list) - 1, -1, -1):
                statement = java_code_list[i]
                # 使用正则表达式提取完整独立的单词
                words_in_statement = re.findall(r'\b\w+\b', statement)
                if variable_name in words_in_statement:
                    last_index = i
                    break
            variable_names[variable_name] = last_index

        code_blocks[-1].append(java_code)

    return code_blocks

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
    
def get_test_ids(parent_directory):
    # 获取所有子文件夹的名称
    subfolders = [f.name for f in os.scandir(parent_directory) if f.is_dir()]
    
    # 提取所有test_id
    test_ids = [folder_name.split('_')[1] for folder_name in subfolders]
    
    return test_ids

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

folder_path = system_path + '/CTCA/data/last_data/' + project_name + '/first_code'
if os.path.exists(system_path + '/CTCA/data/last_data/' + project_name + '/slicing_result'):
    shutil.rmtree(system_path + '/CTCA/data/last_data/' + project_name + '/slicing_result')
if os.path.exists(system_path + '/CTCA/data/last_data/' + project_name + '/slicing_import'):
    shutil.rmtree(system_path + '/CTCA/data/last_data/' + project_name + '/slicing_import')
if os.path.exists(system_path + '/CTCA/data/last_data/' + project_name + '/slicing_extract'):
    shutil.rmtree(system_path + '/CTCA/data/last_data/' + project_name + '/slicing_extract')
os.makedirs(system_path + '/CTCA/data/last_data/' + project_name + '/slicing_result', exist_ok=True)
os.makedirs(system_path + '/CTCA/data/last_data/' + project_name + '/slicing_import', exist_ok=True)
os.makedirs(system_path + '/CTCA/data/last_data/' + project_name + '/slicing_extract', exist_ok=True)

# 遍历文件夹下的所有文件夹
for id in get_test_ids(folder_path):
    file_path = os.path.join(folder_path, f'test_{id}')

    # 获取目录及其子目录下的所有 Java 文件
    java_files_path = list(find_java_files(file_path))

    for java_file_path in java_files_path:
        print(java_file_path)
        # 读取Java代码文件
        try:
            with open(java_file_path, 'r', encoding='utf-8') as file:
                java_code = file.read()
        except FileNotFoundError:
            print(f"The file '{java_file_path}' does not exist.")
        except Exception as e:
            print(f"An error occurred: {e}")

        java_code = remove_annotation(java_code)

        # 按方法来分割代码
        methods = extract_test_methods(java_code)

        # 提取import语句
        import_statements = extract_import_statements(java_code)

        extract_code = extract_no_test_import(java_code, import_statements)
        # 打印每个方法的代码
        #for i, method_code in enumerate(methods, 1):
        #   print(f"Method {i}:\n{method_code}\n{'-'*20}")
        
        new_method_number = count_files_recursively(system_path + '/CTCA/data/last_data/' + project_name + '/slicing_result')

        '''
        new_methods = []
        for i, method_code in enumerate(methods, 1):
            print(f"Method {i}")
            # print(method_code)
            # 按语句拆分 Java 代码，并合并for，while，try-catch代码块
            java_statements = split_and_merge_java_code(method_code)
            
            # 打印每个语句
            #for i, statement in enumerate(java_statements, 1):
            #    print(f"Statement {i}:\n{statement}\n{'-'*20}")

            result = split_java_code(java_statements)
            for i, block in enumerate(result, 1):
                new_methods.append(f"@Test\n" + f"public void test_{new_method_number}() throws Exception {{\n" + f'\n'.join(block) + f"\n}}")
                new_method_number += 1
        
        for method in new_methods:
            # print(method)
            pattern = re.compile(r'public\svoid\stest_(\d+)')
            id = int(pattern.findall(method)[0])
            with open(system_path + '/CTCA/data/last_data/' + project_name + f'/slicing_result/test_{id}.txt', 'w') as file:
                # 写入内容到文件
                file.write(method)
            with open(system_path + '/CTCA/data/last_data/' + project_name + f'/slicing_import/test_{id}.txt', 'w') as file:
                # 写入内容到文件
                for import_statement in import_statements:
                    file.write("%s\n" % import_statement)
            with open(system_path + '/CTCA/data/last_data/' + project_name + f'/slicing_extract/test_{id}.txt', 'w') as file:
                # 写入内容到文件
                file.write(extract_code)

        '''
        for method in methods:
            # print(method)
            # pattern = re.compile(r'public\svoid\stest_(\d+)')
            # id = int(pattern.findall(method)[0])
            with open(system_path + '/CTCA/data/last_data/' + project_name + f'/slicing_result/test_{new_method_number}.txt', 'w') as file:
                # 写入内容到文件
                file.write(f"@Test\n" + f"public void test_{new_method_number}() throws Exception {{" + method + f"}}")
            with open(system_path + '/CTCA/data/last_data/' + project_name + f'/slicing_import/test_{new_method_number}.txt', 'w') as file:
                # 写入内容到文件
                for import_statement in import_statements:
                    file.write("%s\n" % import_statement)
            with open(system_path + '/CTCA/data/last_data/' + project_name + f'/slicing_extract/test_{new_method_number}.txt', 'w') as file:
                # 写入内容到文件
                file.write(extract_code)
            new_method_number += 1
        
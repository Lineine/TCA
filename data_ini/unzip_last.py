import os
import zipfile
import shutil
import tqdm
'''
2526: Anagram Brainfuck
3816: AStar TernaryTree
5190: Othello SegmentTree
6264: GTree ITree
7056: BinaryDecisionDiagram NIOServer
8058: Square UnrolledLinkedList2023
'''
def extract_max_zip_files(main_folder, output_folder):
    subfolders = [f.path for f in os.scandir(main_folder) if f.is_dir()]

    for i in tqdm.trange(len(subfolders)):
        subfolder = subfolders[i]
        bdd_zip_files = []
        nio_zip_files = []
        for entry in os.scandir(subfolder):
            if entry.is_file() and entry.name.startswith("Square_") and entry.name.endswith(".zip"):
                bdd_zip_files.append(entry)
            elif entry.is_file() and entry.name.startswith("UnrolledLinkedList2023_") and entry.name.endswith(".zip"):
                nio_zip_files.append(entry)

        if bdd_zip_files:
            max_bdd_zip = max(bdd_zip_files, key=lambda x: int(x.name.split("_")[1].split(".")[0]))
            temp_extract_folder = "temp_extract"
            shutil.unpack_archive(max_bdd_zip.path, temp_extract_folder, 'zip')
            first_file = os.listdir(temp_extract_folder)[0]

            target_file_path = os.path.join(output_folder, first_file)
            if os.path.exists(target_file_path):
                base_name, extension = os.path.splitext(first_file)
                new_file_name = base_name + "_1" + extension
                target_file_path = os.path.join(output_folder, new_file_name)

            shutil.move(os.path.join(temp_extract_folder, first_file), target_file_path)

            shutil.rmtree(temp_extract_folder)

            '''
            with zipfile.ZipFile(max_bdd_zip, 'r') as zip_ref:
                first_file = zip_ref.namelist()[0]  # 获取压缩包中的第一个文件
                zip_ref.extract(first_file, output_folder)
            '''

        if nio_zip_files:
            max_nio_zip = max(nio_zip_files, key=lambda x: int(x.name.split("_")[1].split(".")[0]))
            shutil.unpack_archive(max_nio_zip.path, temp_extract_folder, 'zip')
            first_file = os.listdir(temp_extract_folder)[0]

            target_file_path = os.path.join(output_folder, first_file)
            if os.path.exists(target_file_path):
                base_name, extension = os.path.splitext(first_file)
                new_file_name = base_name + "_1" + extension
                target_file_path = os.path.join(output_folder, new_file_name)

            shutil.move(os.path.join(temp_extract_folder, first_file), target_file_path)

            shutil.rmtree(temp_extract_folder)
            '''
            with zipfile.ZipFile(max_nio_zip, 'r') as zip_ref:
                first_file = zip_ref.namelist()[0]  # 获取压缩包中的第一个文件
                zip_ref.extract(first_file, output_folder)
            '''
            
def extract_and_remove_zip_files(folder_path):
    zip_files = [f.path for f in os.scandir(folder_path) if f.is_file() and f.name.endswith(".zip")]

    for i in tqdm.trange(len(zip_files)):
        zip_file = zip_files[i]
        output_folder = os.path.join(folder_path, os.path.splitext(os.path.basename(zip_file))[0])
        os.makedirs(output_folder, exist_ok=True)
        
        shutil.unpack_archive(zip_file, output_folder, 'zip')
        '''
        with zipfile.ZipFile(zip_file, 'r') as zip_ref:
            zip_ref.extractall(output_folder)
        '''    
        os.remove(zip_file)

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

# '2526'  '3816'  '5190'  '6264'
zip_name = '8058'
print("Zip_name:", zip_name)

folder_path = system_path + '/TCA/data/original_data/' + zip_name
output_path = system_path + '/TCA/data/unzip_last/' + zip_name

folder_path = system_path + '/CTCA/data/unzip_last/' + zip_name
extract_and_remove_zip_files(folder_path)

import os
import shutil

def move_files_by_folder(source_folder, target_folder):
    for root, dirs, files in os.walk(source_folder):
        for folder in dirs:
            if folder.startswith("NIOServer_"):
                current_folder_path = os.path.join(root, folder)
                
                result_folders = [result_folder for result_folder in os.listdir(current_folder_path) 
                                  if os.path.isdir(os.path.join(current_folder_path, result_folder)) and 
                                     result_folder.startswith("result")]

                for result_folder in result_folders:
                    result_folder_path = os.path.join(current_folder_path, result_folder)
                    move_files_in_folder(result_folder_path, target_folder)

def move_files_in_folder(folder_path, target_folder):
    print(f"Processing folder: {folder_path}")

    target_subfolder = os.path.join(target_folder, os.path.basename(folder_path))

    for file in os.listdir(os.path.join(folder_path, "src/test/java/net/mooctest")):
        source_file_path = os.path.join(folder_path, "src/test/java/net/mooctest", file)
        target_file_path = os.path.join(target_subfolder, file)

        os.makedirs(target_subfolder, exist_ok=True)

        shutil.copy(source_file_path, target_file_path)
        print(f"Moved: {source_file_path} to {target_file_path}")

def rename_result_folders(source_folder):
    for root, dirs, files in os.walk(source_folder):
        for folder in dirs:
            if folder.startswith("result"):
                old_folder_path = os.path.join(root, folder)
                rename_result_folder(old_folder_path)

def rename_result_folder(folder_path):
    parent_directory = os.path.dirname(folder_path)

    new_folder_name = f"test_{get_test_folder_index(parent_directory)}"

    new_folder_path = os.path.join(parent_directory, new_folder_name)

    os.rename(folder_path, new_folder_path)
    print(f"Renamed: {folder_path} to {new_folder_path}")

def get_test_folder_index(parent_directory):
    return sum(os.path.isdir(os.path.join(parent_directory, folder)) and folder.startswith("test_") 
               for folder in os.listdir(parent_directory))

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

source_folder = system_path + '/TCA/data/unzip_all'
target_folder = system_path + '/TCA/data/all_data/' + project_name

move_files_by_folder(source_folder, target_folder)

source_folder = system_path + '/TCA/data/all_data/' + project_name

rename_result_folders(source_folder)
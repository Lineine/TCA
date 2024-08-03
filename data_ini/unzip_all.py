import os
import zipfile

def unzip_all_files(source_folder, destination_folder):
    for root, dirs, files in os.walk(source_folder):
        for file in files:
            if file.lower().endswith(".zip"):
                zip_file_path = os.path.join(root, file)
                unzip_file(zip_file_path, destination_folder)

def unzip_file(zip_file_path, destination_folder):
    folder_name = os.path.splitext(os.path.basename(zip_file_path))[0]

    extract_folder = os.path.join(destination_folder, folder_name)
    os.makedirs(extract_folder, exist_ok=True)

    with zipfile.ZipFile(zip_file_path, 'r') as zip_ref:
        zip_ref.extractall(extract_folder)
        print(f"Successfully extracted: {zip_file_path} to {extract_folder}")

def unzip_all_files(source_folder):
    for root, dirs, files in os.walk(source_folder):
        for file in files:
            if file.lower().endswith(".zip"):
                zip_file_path = os.path.join(root, file)
                unzip_and_cleanup(zip_file_path)

def unzip_and_cleanup(zip_file_path):
    folder_name = os.path.splitext(os.path.basename(zip_file_path))[0]

    extract_folder = os.path.join(os.path.dirname(zip_file_path), folder_name)
    os.makedirs(extract_folder, exist_ok=True)

    with zipfile.ZipFile(zip_file_path, 'r') as zip_ref:
        zip_ref.extractall(extract_folder)
        print(f"Successfully extracted: {zip_file_path} to {extract_folder}")

    os.remove(zip_file_path)
    print(f"Deleted: {zip_file_path}")

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

source_folder = system_path + '/CTCA/data/original_data'
destination_folder = system_path + '/CTCA/data/unzip_all'

unzip_all_files(source_folder, destination_folder)

source_folder = system_path + '/CTCA/data/unzip_all'

unzip_all_files(source_folder)

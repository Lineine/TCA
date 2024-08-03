import os
import shutil

'''
2526: Brainfuck: BrainfuckEngine.java       Anagram: Anagram.java
3816: AStar: AStar.java                     TernaryTree: TernaryTree.java
5190: Othello: Othello.java                 SegmentTree: SegmentTree.java
6264: GTree: LevelBFIterator.java           ITree: IntervalTree.java
7056: NIOServer: Message.java               BinaryDecisionDiagram: BDD.java
8058: Square: Square.java                   UnrolledLinkedList2023: UnrolledLinkedList.java
'''
def copy_test_files(source_folder, target_folder):
    subfolders = [f.path for f in os.scandir(source_folder) if f.is_dir()]

    for index, subfolder in enumerate(subfolders, start=1):
        test_folder = os.path.join(subfolder, "src/test/java/net/mooctest")

        message_java_path = os.path.join(subfolder, "src/main/java/net/mooctest", "UnrolledLinkedList.java")
        if os.path.exists(message_java_path):
            if os.path.exists(test_folder):
                dest_subfolder = os.path.join(target_folder, f"test_{get_test_folder_index(target_folder)}")
                os.makedirs(dest_subfolder, exist_ok=True)

                for root, dirs, files in os.walk(test_folder):
                    for file in files:
                        src_file_path = os.path.join(root, file)
                        relative_path = os.path.relpath(src_file_path, test_folder)
                        dest_file_path = os.path.join(dest_subfolder, relative_path)
                        os.makedirs(os.path.dirname(dest_file_path), exist_ok=True)
                        shutil.copy2(src_file_path, dest_file_path)
                        print(f"Moved: {src_file_path} to {dest_file_path}")

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

source_folder_path = system_path + '/CTCA/data/unzip_last/8058'
target_folder_path = system_path + '/CTCA/data/last_data/' + project_name + '/first_code'

if not os.path.exists(target_folder_path):
    os.makedirs(target_folder_path)

copy_test_files(source_folder_path, target_folder_path)
from transformers import BertTokenizer, BertModel, AutoModel, AutoTokenizer
import torch
import os
import re
import numpy as np
import pickle
from tqdm import tqdm

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

def read_java_code(file_path):
    with open(file_path, 'r', encoding='utf-8') as file:
        java_code = file.read()
    return java_code

input_directory = system_path + '/TCA/data/last_data/' + project_name + '/operational_result'
output_embeddings = {}

checkpoint = system_path + '/TCA/sample/codet5p-110m-embedding'
device = "cuda" 

tokenizer = AutoTokenizer.from_pretrained(checkpoint, trust_remote_code=True)
model = AutoModel.from_pretrained(checkpoint, trust_remote_code=True).to(device)

for file_name in tqdm(os.listdir(input_directory)):
    if file_name.endswith('.txt'):
        pattern = re.compile(r'\d+')
        match = pattern.search(file_name)
        number = match.group()

        file_path = os.path.join(input_directory, file_name)
        java_code = read_java_code(file_path)

        inputs = tokenizer.encode(java_code, return_tensors="pt", truncation=True, padding=True).to(device)
        if inputs.size(1) < 512:
            with torch.no_grad():
                embedding = model(inputs)[0]
            output_embeddings[number] = embedding.squeeze(0)
        else:
            window_size = 512
            stride = 256
            windows = [java_code[i:i+window_size] for i in range(0, len(java_code), stride)]

            embeddings = []
            for window in windows:
                inputs = tokenizer.encode(window, return_tensors='pt', truncation=True, padding=True).to(device)
                with torch.no_grad():
                    embedding = model(inputs)[0]
                embeddings.append(embedding)
            output_embeddings[number] = torch.stack(embeddings).mean(dim=0)

        torch.cuda.empty_cache()

file_path = system_path + '/TCA/sample/data/' + project_name + '/codeT5_embeddings.pkl'

os.makedirs(system_path + '/TCA/sample/data/' + project_name, exist_ok=True)

with open(file_path, 'wb') as file:
    pickle.dump(output_embeddings, file)

char_count = {}

folder_path = system_path + '/TCA/data/last_data/' + project_name + '/operational_result'
for filename in tqdm(os.listdir(folder_path)):
    if filename.startswith('test_') and filename.endswith('.txt'):
        id = filename.split('_')[1].split('.')[0]
        
        with open(os.path.join(folder_path, filename), 'r', encoding='utf-8') as file:
            content = file.read()
            char_count[id] = len(content)

file_path = system_path + '/TCA/sample/data/' + project_name + '/char_count.pkl'

with open(file_path, 'wb') as file:
    pickle.dump(char_count, file)

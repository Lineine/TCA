import pickle
import random
import numpy as np
from concurrent.futures import ThreadPoolExecutor, as_completed
import os
import re
from collections import defaultdict
from tqdm import tqdm, trange
import sys
from functools import reduce
import difflib as diff

def compute_similarity_matrix(vectors):
    num_vectors = len(vectors)
    similarity_matrix = np.zeros((num_vectors, num_vectors))

    for i in trange(num_vectors):
        for j in range(num_vectors):
            if j < i:
                similarity_matrix[i, j] = similarity_matrix[j, i]
                continue
            similarity_matrix[i, j] = np.dot(vectors[i], vectors[j]) / (np.linalg.norm(vectors[i]) * np.linalg.norm(vectors[j]))

    return similarity_matrix

'''
def compute_similarity_row(row_idx, vectors, similarity_matrix):
    print(row_idx)
    num_vectors = len(vectors)
    for j in range(num_vectors):
        similarity_matrix[row_idx, j] = np.dot(vectors[row_idx], vectors[j]) / (np.linalg.norm(vectors[row_idx]) * np.linalg.norm(vectors[j]))

def compute_similarity_matrix(vectors):
    num_vectors = len(vectors)
    similarity_matrix = np.zeros((num_vectors, num_vectors))
    i = 0
    with ThreadPoolExecutor() as executor:
        futures = [executor.submit(compute_similarity_row, i, vectors, similarity_matrix) for i in range(num_vectors)]
        for future in as_completed(futures):
            pass  # Future results are already incorporated into the similarity_matrix

    return similarity_matrix
'''


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

file_path = system_path + '/TCA/sample/data/' + project_name + '/codeT5_embeddings.pkl'

with open(file_path, 'rb') as file:
    embeddings = pickle.load(file)

vectors = [embeddings[id].cpu() for id in embeddings.keys()]
similarity_matrix = compute_similarity_matrix(vectors)

file_path = system_path + '/TCA/sample/data/' + project_name + '/embedding_similarity_matrix.pkl'

with open(file_path, 'wb') as file:
    pickle.dump(similarity_matrix, file)


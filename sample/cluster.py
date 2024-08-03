from collections import defaultdict
import pickle
import numpy as np
from sklearn.cluster import KMeans, SpectralClustering
from scipy.cluster.hierarchy import fcluster
from scipy.cluster.hierarchy import linkage
import os
from tqdm import tqdm, trange
import itertools

def kmeans(X, loaded_data, n_clusters):

    kmeans = KMeans(n_clusters=n_clusters, random_state=0)
    clusters = kmeans.fit_predict(X)

    clustered_list = [[] for _ in range(n_clusters)]

    for i, (id_key, tensor) in enumerate(loaded_data.items()):
        clustered_list[clusters[i]].append(id_key)
    
    return clustered_list

def HAC(X, index_to_id, n_clusters):
    Z = linkage(X, 'single')

    labels = fcluster(Z, t=n_clusters, criterion='maxclust')

    clusters = defaultdict(list)

    for i, label in enumerate(labels):
        clusters[label].append(index_to_id[i])

    clusters_list = list(clusters.values())

    return clusters_list

def recursive_cluster(X, index_to_id, clustered_list, max_cluster_size, min_clusters, clustered_method):
    new_clusters_list = []  
    id_to_index = {index_to_id[index]:index for index in range(len(index_to_id))}
    for i in trange(len(clustered_list)):
        cluster = clustered_list[i]
        if len(cluster) > max_cluster_size:
            sub_X = [X[id_to_index[id]] for id in cluster]
            sub_index_to_id = [id for id in cluster]

            if clustered_method == 'kmeans':
                kmeans_clustering = KMeans(n_clusters=min_clusters, affinity='nearest_neighbors')

                clusters = kmeans_clustering.fit_predict(sub_X)
                sub_clusters = [[] for _ in range(min_clusters)]

                for i in range(len(clusters)):
                    sub_clusters[clusters[i]].append(sub_index_to_id[i])

            if clustered_method == 'HAC':
                sub_clusters = HAC(sub_X, sub_index_to_id, min_clusters)
            
            if clustered_method =='SpectralClustering':
                spectral_clustering = SpectralClustering(n_clusters=min_clusters, affinity='nearest_neighbors')

                clusters = spectral_clustering.fit_predict(np.array(sub_X))
                sub_clusters = [[] for _ in range(min_clusters)]

                for i in range(len(clusters)):
                    sub_clusters[clusters[i]].append(sub_index_to_id[i])
            sub_clusters_list = recursive_cluster(sub_X, sub_index_to_id, sub_clusters, max_cluster_size, min_clusters, clustered_method)
            new_clusters_list.extend(sub_clusters_list)
        else:
            new_clusters_list.append(cluster)

    return new_clusters_list


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

# 'kmeans' 'HAC' 'SpectralClustering'
clustered_methods = ['HAC']

# 'kmeans' 'HAC' 'SpectralClustering'
recursive_clustered_method = 'SpectralClustering'

n_clusters_list = [i for i in range(5, 501, 5)]
experiment_params = itertools.product(clustered_methods, n_clusters_list )
for clustered_method, n_clusters in tqdm(experiment_params):

    file_path = system_path + '/TCA/sample/data/' + project_name + '/codeT5_embeddings.pkl'

    with open(file_path, 'rb') as file:
        loaded_data = pickle.load(file)

    if n_clusters > len(loaded_data):
        continue

    index_to_id = list(loaded_data.keys())

    tensor_values = [loaded_data[id].cpu().numpy() for id in index_to_id]
    X = np.array(tensor_values)

    if n_clusters == 1:
        clustered_list = [list(loaded_data.keys())]
    elif clustered_method == 'kmeans':
        clustered_list = kmeans(X, loaded_data, n_clusters)
    elif clustered_method == 'HAC':
        clustered_list = HAC(X, index_to_id, n_clusters)


    # for i, clusters in enumerate(clustered_list, 1):
    #     print(f"Cluster {i}: {clusters}")

    file_path = system_path + '/TCA/sample/data/' + project_name + '/clustered_list_' + clustered_method + f'_{n_clusters}.pkl'

    with open(file_path, 'wb') as file:
        pickle.dump(clustered_list, file)
# TCA: Test Code Aggregation

This is the source code for the paper "Enhancing Test Efficiency and Quality through Test Code Aggregation: An Empirical Analysis".

## Prepare dataset

The download link for the source data:

- Google Drive: [https://drive.google.com/file/d/1Zfyvw2-OErQuwMefQy9KpGcLwwFVZDF3/view?usp=sharing](https://drive.google.com/file/d/1Zfyvw2-OErQuwMefQy9KpGcLwwFVZDF3/view?usp=sharing)

## Prepare models

During the experiment, you will need CodeT5+. We provide the download URL:

- CodeT5+: [https://huggingface.co/Salesforce/codet5p-110m-embedding](https://huggingface.co/Salesforce/codet5p-110m-embedding)

Please put the downloaded model into the folder `sample`

## Proprecess

In `globals.py`, you can control the dataset selection by modifying `PROJECT_NAME`. Next, run in the following order:

1. Run the Python scripts in the `code_slicing` directory to slice the initial test suites.
2. Run `initial_code_coverage_test.py` in the `coverage_test` directory to obtain the coverage information for each initial test suite. In this step, you can obtain the branch coverage information for each test suite of each project.
3. Run `coverage_distribution.py` in the `coverage_test` directory to get the distribution of the initial test suite coverage. 
4. Run `operational_code.py` in the `coverage_test` directory to determine the compilation status of each test snippet.
5. Run `code_deduplication.py` in the `coverage_test` directory to remove test snippets that not only compile but also meet specific criteria.
6. Run `code_representation.py` in the `sample` directory to obtain the representation of each test snippet.
7. Run `build_matrix.py` in the `sample` directory to get the weight matrix.
8. Run `cluster.py` in the `sample` directory to perform clustering.
9. Run `sample.py` in the `sample` directory to randomly select a test snippet from each cluster for aggregation. In this step, you can control the sampling strategy to obtain the results for RQ3.
10. Finally, you can find the results in the `coverage_test` directory.

The dataset contains the complete data of each project, as well as the datasets without the 5% and 10% highest coverage test suites, which are named XXX_sub_5 and XXX_sub_10. By executing the above steps on different datasets, you can obtain the results for RQ1, RQ2.1 and RQ4. The results of each project also include a `branch_point` folder, through which you can get the data required by rq2.2. To implement RQ3, you should set **n_clusters** to 1 and 200 in line 189 of `sample` directory, set **sample_method** to 'loop_Random', and then set the loop condition to 1 to 300 in line 214.

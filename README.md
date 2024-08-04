# TCA: Test Code Aggregation

This is the source code for the paper "Enhancing Test Efficiency and Quality through Test Code Aggregation: An Empirical Analysis".

## Prepare dataset

The download link for the source data:

- Google Drive: https://drive.google.com/drive/folders/1ZSMDuiJTG_iLMmoM7X8pp6ysUbP6cyF8?usp=drive_link

You can process the compressed package using the Python scripts in the `data_ini` directory.

You can also obtain the processed set of test cases for each project through the following link:

- Google Drive: https://drive.google.com/file/d/1Zfyvw2-OErQuwMefQy9KpGcLwwFVZDF3/view?usp=sharing

## Prepare models

During the experiment, you will need CodeT5+. We provide the download URL:

- CodeT5+: [https://huggingface.co/Salesforce/codet5p-110m-embedding](https://huggingface.co/Salesforce/codet5p-110m-embedding)

Please put the downloaded model into the folder `sample`

## Proprecess

In `globals.py`, you can control the dataset selection by modifying `PROJECT_NAME`. Next, run in the following order:

1. Run the Python scripts in the `code_slicing` directory to slice the initial test cases.
2. Run `initial_code_coverage_test.py` in the `coverage_test` directory to obtain the coverage information for each initial test case. In this step, you can obtain the branch coverage information for each test case of each project, thereby obtaining the results for RQ5.
3. Run `coverage_distribution.py` in the `coverage_test` directory to get the distribution of the initial test case coverage.
4. Run `operational_code.py` in the `coverage_test` directory to determine the compilation status of each test fragment.
5. Run `code_deduplication.py` in the `coverage_test` directory to remove test fragments that not only compile but also meet specific criteria.
6. Run `code_representation.py` in the `sample` directory to obtain the representation of each test fragment.
7. Run `build_matrix.py` in the `sample` directory to get the weight matrix.
8. Run `cluster.py` in the `sample` directory to perform clustering.
9. Run `sample.py` in the `sample` directory to randomly select a test fragment from each cluster for aggregation. In this step, you can control the sampling strategy to obtain the results for RQ6.
10. Finally, you can find the results in the `coverage_test` directory.

By executing the above steps on different datasets, you can obtain the results for RQ1, RQ2, RQ3, and RQ4.

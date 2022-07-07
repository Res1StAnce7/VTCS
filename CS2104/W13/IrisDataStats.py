'''
https://machinelearningmastery.com/machine-learning-in-python-step-by-step/
Loads a dataset with assosciated attribute names, then reports on details
of the dataset including statistics and graphs
'''

# Load libraries
import pandas
from pandas.plotting import scatter_matrix
import matplotlib.pyplot as plt


# Load dataset
file = "C:/Users/Siliang Zhang/Desktop/Test/Test_Python/W13/iris.csv"
names = ['sepal-length', 'sepal-width', 'petal-length', 'petal-width', 'class']

# load data from the csv file with columns labeled by names into a DataFrame called dataset
dataset = pandas.read_csv(file, names=names)

# print the dimensions of the dataset
print("The file has data with dimensions: ")
print(dataset.shape)

# print the first 20 rows of the dataset
print("The first 20 rows of the dataset are: ")
print(dataset.head(20))

# print the summary statistics of the dataset
print("The summary statistics of the dataset are: ")
print(dataset.describe())

# print the class distributions of the dataset
print("The class distributions of the dataset are: ")
print(dataset.groupby('class').size())

# plot the boxplot of the dataset
dataset.plot(kind='box', subplots=True, layout=(2,2), sharex=False, sharey=False)
plt.show()

# plot the histogram of the dataset
dataset.hist()
plt.show()

# scatter plot matrix of the dataset
scatter_matrix(dataset)
plt.show()


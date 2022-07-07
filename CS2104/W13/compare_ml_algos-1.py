# Adapted from:
# https://machinelearningmastery.com/machine-learning-in-python-step-by-step/

# Load libraries
import pandas
from pandas.plotting import scatter_matrix
import matplotlib.pyplot as plt
from sklearn import model_selection
from sklearn.metrics import classification_report
from sklearn.metrics import confusion_matrix
from sklearn.metrics import accuracy_score
from sklearn.tree import DecisionTreeClassifier
from sklearn.neighbors import KNeighborsClassifier
from sklearn.svm import SVC
from sklearn.neural_network import MLPClassifier

# Load dataset
# Specify names for the columns in the csv data that we are about to read
names = ['sepal-length', 'sepal-width', 'petal-length', 'petal-width', 'class']
# load data from a local file.
dataset = pandas.read_csv("C:/Users/Siliang Zhang/Desktop/Test/Test_Python/W13/iris.csv", names=names)

# Optionally some statistical information from/about the data set. 
print_stats = True

if (print_stats):
    # shape
    print(dataset.shape)

    # head
    print(dataset.head(20))

    # descriptions
    print(dataset.describe())

    # class distribution
    print(dataset.groupby('class').size())

    # box and whisker plots
    dataset.plot(kind='box', subplots=True, layout=(2,2), sharex=False, sharey=False)
    plt.show()

    # histograms
    dataset.hist()
    plt.show()

    # scatter plot matrix
    scatter_matrix(dataset)
    plt.show()

#Prep data for machine learning

# Split out validation dataset
array = dataset.values

# sub-array containing the first four columns (sepal/petal lengths and widths)
X = array[:,0:4]
# sub-array containing the last column (species name)
Y = array[:,4]

# Uncomment these to see sub-array contents
# print(X)
# print(Y)

# Hold back 20% of the dataset for validation. (i.e., train with 80% of the
# data, then test the trained model against the data that it didn't use for
# training)
test_size = 0.20

# Seed for random-number generator used to split up the training data. We define this
# so that we can repeat trials with the same (pseudo-)random 80/20 split.
seed = 7 
X_train, X_test, Y_train, Y_test = model_selection.train_test_split(X, Y, test_size=test_size, random_state=seed)

# Test Harness
# Test options and evaluation metric
seed = 7
scoring = 'accuracy'

# Store the Algorithms
models = []

# Use implementations of the four algorithms discussed in the lecture.
# Each of these has _many_ more parameters that can be used to tweak
# its behavior for different kinds of data sets and to meet different
# speed vs. accuracy constraints. 

# K-nearest neighbors
# https://scikit-learn.org/stable/modules/generated/sklearn.neighbors.KNeighborsClassifier.html
models.append(('KNN', 
    KNeighborsClassifier(
        n_neighbors = 20  # Number of neighbors to consider when classifying.
                          # Default is 5
    )))

# Decision tree
# https://scikit-learn.org/stable/modules/generated/sklearn.tree.DecisionTreeClassifier.html
models.append(('CART', 
    DecisionTreeClassifier(
        max_depth=20     # An int or None (with no quotes, to allow any depth)
    )))

# Support Vector Classification
# https://scikit-learn.org/stable/modules/generated/sklearn.svm.SVC.html
models.append(('SVM', 
     SVC(
         kernel='linear', # May be 'rbf', 'linear', 'poly', 'sigmoid', or custom

         gamma='auto'  # Defaults to 'auto'. A future version of sklearn will
                       # require this parameter, rather than falling back to
                       # the default. In the current version of sklearn, you
                       # will simply get a warning if you leave it out. Use
                       # the default, or see this page for more information
                       # on what it actually does:
                       # https://scikit-learn.org/stable/auto_examples/svm/plot_rbf_parameters.html
     )))

# MLPClassifier implements a neural network
# https://scikit-learn.org/stable/modules/generated/sklearn.neural_network.MLPClassifier.html
models.append(('MLP', 
    MLPClassifier(
       hidden_layer_sizes=(200,), # List of hidden layer sizes (number of
                                  # neurons in each layer). This defaults
                                  # to a single hidden layer with 100 
                                  # neurons. Try (10, 10) as an alternative.

       max_iter=1000              # Max number of training iterations.
    )))



# evaluate each model in turn
print ('Mean scores (and stddevs) from cross-validation training of algorithms')
results = []
names = []
i = 0 
best_score = 0.0
best_model = 0
for name, model in models:
    # For each model, split the training data into 10 equal parts. Then
    # use each of those parts as cross validation data for the model trained on
    # the other nine parts. See here for more information:
    # https://scikit-learn.org/stable/modules/generated/sklearn.model_selection.KFold.html
    # https://scikit-learn.org/stable/modules/generated/sklearn.model_selection.cross_val_score.html
    kfold = model_selection.KFold(n_splits=10, random_state=seed, shuffle=True)
    cv_results = model_selection.cross_val_score(model, X_train, Y_train, cv=kfold, scoring=scoring)

    # Save the results for generating a plot after we've run all of the
    # models
    results.append(cv_results)
    names.append(name)
    
    # Print the model name, the mean score of the 10 runs, and the standard
    # deviation of the 10 runs
    msg = "%s: %f (%f)" % (name, cv_results.mean(), cv_results.std())
    print(msg)

    # Save the best one, so we can compare it to the test data that we
    # saved earlier in the script
    if cv_results.mean() > best_score:
        best_score = cv_results.mean()
        best_model = i
    i = i + 1

# Compare Algorithms
fig = plt.figure()
fig.suptitle('Algorithm Comparison')
ax = fig.add_subplot(111)
plt.boxplot(results)
ax.set_xticklabels(names)
# Uncomment to show the plots
# plt.show()

# Use the model that performed the best to make predictions on 
# entire validation dataset, compare to the test set
(name, model) = models[best_model];

print ()
print ('Best model was ' + name + '. Testing against validation data set:');
model.fit(X_train, Y_train)
predictions = model.predict(X_test)
print ('Accuracy score:')
print(accuracy_score(Y_test, predictions))




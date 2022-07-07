# -*- coding: utf-8 -*-
# coding: utf-8
#Naive Bayes
import os
import io
import numpy
from pandas import DataFrame
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.naive_bayes import MultinomialNB

#This function does the heavy lifting in this assignment. It's job is to go through the files at a given path and return 
# the emails contained in the files.
def readFiles(path):
    # this is how we iterate across files at 'path'
    for root, dirnames, filenames in os.walk(path):
        # because our route only has files...
        for filename in filenames:
            #absolute path to file
            path = os.path.join(root, filename)

            # TODO4:consider having a flag that will help with distinguishing between 'header' and 'body' inside the loop below.
            blank = False
            #this is where the lines fro email body will be saved.
            lines = []
            # opening current file for reading. The 'r' param means read access. 
            f = io.open(path, 'r', encoding='latin1')
            #reading one line at a time
            for line in f:
                #print("This will print if you finish TODO_0")
                
                # TODO3: here you need to determine whether a given line is from the header or body of the email.
                
                # TODO2: need to add the line to the array variable? How do you do that?
                if (blank):
                    lines.append(line)   
                elif (line == '\n'):
                    blank = True    
                    
                 # HINT: look at the emails manually and notice what separates the header and body content.
                # special characters: https://docs.python.org/2.0/ref/strings.html
            # after the loop is finished, close the file.
            f.close()
            # goes through each string and combines into a big strink separated with spaces.
            message = '\n'.join(lines)
            #TODO: research the difference between 'yield' and 'return' to understand why we use yield here.
            yield path, message

# This function relies on the function above. Here, we grab the emails from the above function and 
# place them into individual data frames (you can think of it as if it is a table of JSONs where each JSON has an email plus its 
# classification)
def dataFrameFromDirectory(path, classification):
    rows = []
    index = []
    
    #TODO1: before readFiles is finished, look at 'path' again and verify that it is valid.
    for filename, message in readFiles(path):
        if os.path.exists(path):
            rows.append({'message': message, 'class': classification})
            index.append(filename)

        #data frame object takes two arrays 'rows'=emails, and 'index'=filenames
    return DataFrame(rows, index=index)

#This is a convenient class that allows you to create a table-like structure. 
# In our case we are trying to a column with the messages and a column that classifies the type
# of the message.
data = DataFrame({'message': [], 'class': []})

#Including the email details with the spam/ham classification in the dataframe
# TODO_0: you must specify the path of the unzipped folders
data = data.append(dataFrameFromDirectory('C:/Users/Siliang Zhang/Desktop/Test/Test_Python/W12/spam', 'spam'))
data = data.append(dataFrameFromDirectory('C:/Users/Siliang Zhang/Desktop/Test/Test_Python/W12/ham', 'ham'))

#Step 5
#data = data.append(dataFrameFromDirectory('C:/Users/Siliang Zhang/Desktop/Test/Test_Python/W12/spam_test', 'spam'))
#data = data.append(dataFrameFromDirectory('C:/Users/Siliang Zhang/Desktop/Test/Test_Python/W12/ham_test', 'ham'))

#TODO5: lookup the documentation of Dataframe: https://pandas.pydata.org/pandas-docs/stable/reference/api/pandas.DataFrame.html
# and print the content of the data frames.
#print(data.to_string())

#TODO6: can you find a function that lets you preview a portion of 'data' ? Try this with the full dataset.
#Head and the Tail of 'data'
#print(data.head())
#print(data.tail())


# ***this code should be added at the bottom****





#CountVectorizer is used to split up each message into its list of words
#Then we throw them to a MultinomialNB classifier function from scikit
#2 inputs required: actual data we are training on and the target data
vectorizer = CountVectorizer()

# vectorizer.fit_trsnform computes the word count in the emails and represents that as a frequency matrix (e.g., 'free' occured 1304 times.)
counts = vectorizer.fit_transform(data['message'].values)

#we will need to also have a list of ham/spam (corresponding to the emails from 'counts') that will allow Bayes Naive classifier compute the probabilities.
targets = data['class'].values

# This is from the sklearn package. MultinomialNB stands for Multinomial Naive Bayes classsifier
classifier = MultinomialNB()
# when we feed it the word frequencies plus the spam/ham mappings, the classifier will create a table of probabilities similar ot the one that you saw in the first assignment in this module.
classifier.fit(counts, targets)

#Time to have fun! You can compute P(ham| email text) and P(spam | email text) using classifier.predict(...emails...) 
#... but in what format should we supply the emails we want to test?

#lets say we have the following emails
sample = ['Free iPhone!', "We regret to inform that your paper has been rejected."]

# first, transform this list into a table of word frequencies.
sample_counts = vectorizer.transform(sample)

# after that you are ready to do the predictions.
predictions = classifier.predict(sample_counts)

# get the numerical probabilities
proba = classifier.predict_proba(sample_counts)

print(sample, predictions, proba)
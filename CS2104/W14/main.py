from fileinput import filename
import random
import hashlib
import time

# read the words file
def readFile(fileNAme: str):
    # try to open the file
    try:
        with open(fileNAme, 'r') as file:
            # reading each line    
            for line in file:
                # reading each word        
                for word in line.split():
                    # add to the array          
                    words.append(word)
        # print the dictionary
        print("Here is the dictionary\n" + str(words))
    except FileNotFoundError:
        # print the error
        print("File not found")

# generate the password based on the user input
def pickWords(wordsList: str)-> str:
    global nums
    userInput = ""
    # get the user input for the number of words
    nums = input("How many words would like to pick?: ")
    # check the user input
    while (int(nums) < 1):
        nums = input("Invalid input! Please try again: ")
    for i in range(0, int(nums)):
        # get the user input for the word
        givenWord = input("Enter the word number " + str(i + 1) + ": ")
        while givenWord not in wordsList:
            # check the user input
            givenWord = input("This word is not in the dictionary! Please try again: ")
        # add the word to the password
        userInput += givenWord  
    return userInput

def hash(words: list, hashChoice: int):
    if (int(hashChoice) == 1):
        # initialize the attacks
        timeFor256 = attack_256(words, hashlib.sha256(userWord.encode()).hexdigest())
        # print the time
        print("The time to crack the password(SHA_256) is: " + str((timeFor256)  / (10 ** 9)) + " seconds")
    elif (int(hashChoice) == 2):
        # initialize the attacks
        timeFor512 = attack_512(words, hashlib.sha512(userWord.encode()).hexdigest())
        # print the time
        print("The time to crack the password(SHA_512) is: " + str((timeFor512)  / (10 ** 9)) + " seconds")
    else: 
        # initialize the attacks
        timeFor256 = attack_256(words, hashlib.sha256(userWord.encode()).hexdigest())
        timeFor512 = attack_512(words, hashlib.sha512(userWord.encode()).hexdigest())
        # print the time
        print("The time to crack the password(SHA_256) is: " + str((timeFor256)  / (10 ** 9)) + " seconds")
        print("The time to crack the password(SHA_512) is: " + str((timeFor512)  / (10 ** 9)) + " seconds")
        
# attack the sha216
def attack_256(wordslist: list, hash_256: str):
    password = ""
    tempWord = ""
    #start the timer
    start = time.time_ns() 
    while password != hash_256:
        # reset the temp word
        tempWord = ""
        for i in range(0, int(nums)):
            # generate a random word
            tempWord += wordslist[random.randint(0, len(wordslist) - 1)]
        # hash the temp word
        password = hashlib.sha256(tempWord.encode()).hexdigest()    
    # return the time taken
    return time.time_ns() - start

# attack the sha512
def attack_512(words: list, hash_512: str):
    password = ""
    tempWord = ""
    #start the timer
    start = time.time_ns()    
    while password != hash_512:
        # reset the temp word
        tempWord = ""
        for i in range(0, int(nums)):
            # generate a random word
            tempWord += words[random.randint(0, len(words) - 1)]
        # hash the temp word
        password = hashlib.sha512(tempWord.encode()).hexdigest()
    # return the time taken
    return time.time_ns() - start
        
quit = False

while quit == False:       
    words = []
    nums = 0
    timeFor256 = 0
    timeFor512 = 0
    hashChoice = 0

    # read the file from the directory(REMEBER TO CHANGE IT)
    readFile('C:/Users/Siliang Zhang/Desktop/Test/Test_Python/W14/words.txt')

    # generate the userword
    userWord = pickWords(words)

    # hash options
    print("How would you like to hash the password?")
    print("1. SHA-256\n2. SHA-512\n3. Both")
    hashChoice = input("Input your choice: ")

    # check the user input
    while (int(hashChoice) < 1 or int(hashChoice) > 3):
        hashChoice = input("Invalid input! Please try again: ")
    
    # hash the userword
    hash(words, hashChoice)
    
    # offer user the option to rerun the program
    rerun= input("Do you want to rerun the program? (y/n): \n")
    if rerun == "n":
        quit = True


def isAValidCardNo(num):
    size = len(str(num))
    if size == 16:
        index = 1
        sum = 0
        while size >= 1:   
            currentDigit = int(str(num)[index - 1])
            if (index % 2 == 1):
                sum = sum + currentDigit   
            else:
                tempInt = currentDigit * 2
                if (tempInt > 9):
                    sum = sum + int(str(tempInt)[0]) + int(str(tempInt)[1])
                else:
                    sum =  sum + tempInt
            size = size - 1
            index = index + 1
        if (sum % 10 == 0):
            print("The card number is valid.")
        else:
            print("The card number is invalid.")          
    else:
        print("The card number is invalid.")

isAValidCardNo(235466)
isAValidCardNo(9090909090909090)
isAValidCardNo(9890959090909090)
isAValidCardNo(5050505050505050)

            
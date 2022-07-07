def prime(a, b):
    arr = []
    num = a
    while (num <= b):
        i = 2
        isPrime = True
        while (i < num):
            isInArr = i in arr
            if (isInArr == False and num % i == 0):
                isPrime = False
                break
            i = i + 1
        if (isPrime):
            arr.append(num)
            print(num)
        num = num + 1
        
prime(100, 200)    
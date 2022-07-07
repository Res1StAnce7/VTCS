def productOf12Nums(numbers):
    size = 12
    index = 0
    product = 1
    while size >= 1:
        product = product * numbers[index]
        index = index + 1
        size = size - 1
    print("The product of the 12 numbers is：", product)
    
        
productOf12Nums([2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2])      


    
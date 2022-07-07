def sum_1(values):
    size = len(values)
    max_sum = 0
    i = 0
    while i < size:
        j = i    
        while j < size:
            this_sum = 0
            k = i
            while k <= j:
                this_sum = this_sum + values[k]
                k = k + 1
            if (this_sum > max_sum):
                max_sum = this_sum
            print(max_sum, i, j, this_sum, k-1, size)
            j = j + 1
        i = i + 1
    return max_sum    

def sum_2(values):
    size = len(values)
    max_sum = 0
    i = 0
    while i < size:
        j = i    
        this_sum = 0
        while j < size:
            this_sum = this_sum + values[j] 
            if (this_sum > max_sum):
                max_sum = this_sum
            print(max_sum, j, this_sum, size)
            j = j + 1
        i = i + 1
    return max_sum 

def sum_3(values):
    size = len(values)
    max_sum = 0
    this_sum = 0
    j = 0
    while (j <= size - 1):
        this_sum = this_sum + values[j] 
        if (this_sum > max_sum):
            max_sum = this_sum
        elif (this_sum < 0):
            this_sum = 0
        print(max_sum, j, this_sum, size)
        j = j + 1
    return max_sum

sum_3([-2, 1, 5, -3, 8, -4, 2, -1])
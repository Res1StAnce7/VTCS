"""
@date: 02/20/2022
@author: Siliang Zhang
@PID: s589z417
@assignment: Recursion
@note: Do NOT alter the function headers that are well documented
"""

def sum_digits(number: int) -> int:
    """ Sums each digit of a number together using recursion
    @param number: an integer whose digits will be summed
    @return: the sum of all digits in the number
    """
    if (number == 0):
        return 0
    num = abs(number)
    return int(num % 10 + sum_digits((num-(num % 10)) / 10))

def is_diff_two(values: list, diff: int) -> bool:
    """ Checks if there are two elements within a list that have a specific difference between them using recursion 
    @param values: The list of integer values to be searched
    @param diff: The difference value between two elements to find
    @return: True if there are two elements in values with a difference of diff, otherwise False
    """
    return search(len(values), 0, 1, diff, values)
    

def search(length: int, i: int, j: int, diff: int, values: list) -> bool:
    """ Checks if there are two elements within a list that have a specific difference between them using recursion 
    @param values: The list of integer values to be searched
    @param diff: The difference value between two elements to find
    @return: True if there are two elements in values with a difference of diff, otherwise False
    """
    if (i >= length - 1):
        return False
    elif (abs(values[i] - values[j]) == diff):
        return True
    else:
        if (j < length - 1):
            return search(length, i, j + 1, diff, values)
        else:
            return search(length, i + 1, i + 2, diff, values)
    

"""
@date: 02/16/2022
@author: Siliang Zhang
@PID: s589z417
@assignment: Algorithm Efficiency
@note: Do NOT alter the function headers that are well documented
"""


def max_difference(values: list) -> float:
    """ Efficiently finds the largest difference between any two elements in a list
    @param values: a list of numbers
    @return number for the largest difference between elements
    """
    max = values[0]
    min = values[0]
    for i in range(1, len(values)):
        if (values[i] > max):
            max = values[i]
        elif (values[i] < min):
            min = values[i]
    return float(max - min)


def sort_bivalued(values: list) -> list:
    """Efficiently sort a list of binary values
    @param values: a list of binary digits (0 or 1)
    @return: a list of binary numbers in ascending sort order
    """
    j = -1
    for i in range(len(values)):
        if (values[i] == 0):
            j += 1
            temp = values[j]
            values[j] = values[i]
            values[i] = temp
    return values

print(max_difference([0, 0, 5, 1, 0, 0, 4, 1]))
print(sort_bivalued([0, 1, 1, 1, 0, 1, 0, 0, 1, 0]))
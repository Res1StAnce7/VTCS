"""
@date: 02.08.2022
@author: Siliang Zhang
@PID: s589z417
@assignment: Algorithms
@note: Do NOT alter the function headers that are well documented, 
Do put your hw answers in the spaces provided within function headers
"""

def log_base_2(number: float) -> str:
    """ Gives the approximate log base 2 calculation of the input number
    @param number: float to calculate on
    @precondition: number is > 0
    @return str: A string description of the approximate result
    parts i-iii from HW
    i. Work out the steps to figure out the 2 concrete examples of 256 and 81
    step by step and briefly explain your work and thinking(5pts)
    256 is the eighth power of two, so we can find the 8 for the answer.
    81 is the x power of two, but we cannot find an integar for the answer and we need
    to find the range. The upper boundary power of 2 is greater than 81, while the lower 
    boundary power of 2 is smaller that 81. 
    
	ii. Find and describe a pattern and attempt to generalize (5pts)
    From the example. we can tell that he upper boundary power of 2 is greater than 81, 
    while the lower boundary power of 2 is smaller that 81. We can try to find a number 
    (an Integer) which make the input number equal the xxth power of 2. Or we can find the
    upper boundary and get the lower one (upper boundary - 1)./
    I use a while loop to get the number that loop while stop and the value of power 
    is greater that input number. If the number(th) power of 2 exactly equals the input value,
    then return the number. If it does not, then use the number the as upper boundary and 
    the value of (number - 1) to be lower boundary.
    
	iii. Investigate and explain special cases to see if the pattern holds up (5pts)
    The inputs between (0 and 1) seem to be special and the pattern still holds up. 
    But the algorithm is slightly different which can be told from below.
    For example when the input the 0.1, we will get "between -4 and -3" and the correct
    value of log2(0.6) is -0.73696 which is the range.
    I think there are no other special cases in this one. Because we either find 
    an integar or a range that the difference of two boundries will always be one.
    """
    num = 0
    if (number >= 1):
        while (pow(2, num) < number):
            num += 1
        if (pow(2,num) != number):
            return "between " + str(num - 1) + " and " + str(num)
    else:
        while (pow(2, num) > number):
            num -= 1
        if (pow(2,num) != number):
            return "between " + str(num) + " and " + str(num + 1)
    return str(num)
    

def reverse_list(aList: list) -> list:
    """Gives a list with the elements in reversed order
    @param aList: list input that's going to be reversed
    @return list: the reversed version of the input list
    parts i-iii from HW
    i. Work out the steps to figure out a concrete example and briefly explain
    your work and thinking(5pts)
    If the input array is [1, 2, 3], then we exchange the elements in the array to
    make it [3, 2, 1]
	ii. Find and describe a pattern and attempt to generalize (5pts)
    We can exchange the element from the beginning and the end of array to the middle to 
    get the reversed one.
	iii. Investigate and explain special cases to see if the pattern holds up (5pts)
    An empty array seems special but the function will simply return an empty array.
    I think there are no other speical cases.
    """ 
    front = 0
    back = len(aList) - 1
    while (front < back):
        temp = aList[front]
        aList[front] = aList[back]
        aList[back] = temp
        front += 1
        back -= 1
    return aList

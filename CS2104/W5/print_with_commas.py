def print_with_commas(n, a):
    a = a + 1
    if (n < 0):
        print('-',end='')
        n = -n
    if (n < 1000):
        print(n,end='')
    else:
        print_with_commas(n // 1000, a)
        print('-',end='')
        print(n % 1000,end='')
    print('\na = ', a)

print(print_with_commas(82842083298355, -1))
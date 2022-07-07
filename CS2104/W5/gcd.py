def gcd(m, n, a):
    a = a + 1
    print('a = ', a)
    if (n == 0):
        return m
    return gcd(n, m % n, a)

a = -1
print(gcd(540, 288, a))

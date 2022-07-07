def powr(a, b):
    num = b - 1
    ans = a
    while num > 0:
        ans *= a
        num = num - 1
    return ans

print(powr(3, 2))
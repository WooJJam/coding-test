import sys
sys.setrecursionlimit(10**6)
N = int(sys.stdin.readline())
d = [0] * 46
def fibo(x):
    if x == 1 or x == 2:
        return 1
    if x == 0 :
        return 0
    if d[x] != 0:
        return d[x]
    d[x] = fibo(x-1) + fibo(x-2)
    return d[x]
print(fibo(N))
import sys
sys.setrecursionlimit(10**6)

def factorial(x):
    if x == 1 or x == 0:
        return 1
    if d[x] != 0 :
        return d[x]
    d[x] = factorial(x-1) * x
    return d[x]

def combination(n,r):
    return factorial(n) // (factorial(r) * factorial(n-r))

if __name__ == "__main__":
    T = int(sys.stdin.readline())
    for _ in range(T):
        N, M = map(int, sys.stdin.readline().split())
        d = [0] * 31
        print(combination(M,N))
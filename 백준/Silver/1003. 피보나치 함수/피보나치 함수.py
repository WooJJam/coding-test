import sys
sys.setrecursionlimit(10**7)

def dynamic(x):
    for i in range(3, x+1):
        dp0[i] = dp0[i-1] + dp0[i-2]
        dp1[i] = dp1[i-1] + dp1[i-2]

T = int(sys.stdin.readline())
for _ in range(T):
    dp0 = [0]*41
    dp1 = [1]*41
    dp0[0] = 1
    dp1[0] = 0
    dp0[1] = 0
    dp1[1] = 1
    dp0[2] = 1
    dp1[2] = 1
    x = int(sys.stdin.readline())
    dynamic(x)
    print(dp0[x], dp1[x])
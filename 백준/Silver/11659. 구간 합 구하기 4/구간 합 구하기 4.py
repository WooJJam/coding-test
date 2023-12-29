import sys
N, M = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
SUM = [0] * N
for i in range(N):
    if not i:
        SUM[i] = arr[i]
    else:
        SUM[i] = SUM[i-1] + arr[i]
for _ in range(M):
    i, j = map(int, sys.stdin.readline().split())
    if i == 1:
        print(SUM[j-1])
    else:
        print(SUM[j-1] - SUM[i-2])
import sys
N, M = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
SUM = [0] 
temp = 0

for i in arr:
    temp += i
    SUM.append(temp)

for _ in range(M):
    i, j = map(int, sys.stdin.readline().split())
    print(SUM[j]-SUM[i-1])
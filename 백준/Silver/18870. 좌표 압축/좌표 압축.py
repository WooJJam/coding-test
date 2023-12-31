import sys
from bisect import bisect_left
input = sys.stdin.readline
N = int(input())
X = list(map(int, input().split()))
Y = sorted(set(X))
result = []
for i in range(len(X)):
    result.append(bisect_left(Y, X[i]))
print(*result)
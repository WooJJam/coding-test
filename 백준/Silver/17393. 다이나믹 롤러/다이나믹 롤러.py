import sys
from bisect import bisect_right
input = sys.stdin.readline
N = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
answer = []
for i in range(len(a)):
    target = a[i]
    result = bisect_right(b, target)
    answer.append((result-i)-1)
print(*answer)
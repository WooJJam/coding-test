import sys
from bisect import bisect_right
input = sys.stdin.readline
int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
answer = []
for i in range(len(a)):
    result = bisect_right(b, a[i])
    answer.append((result-i)-1)
print(*answer)
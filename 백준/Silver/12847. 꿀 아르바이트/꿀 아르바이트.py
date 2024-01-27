import sys
input = sys.stdin.readline
n,m = map(int, input().split())
t = list(map(int,input().split()))
MAX_SUM = sum(t[:m])
answer = MAX_SUM
for i in range(m,n):
    MAX_SUM += t[i] - t[i-m]
    answer = max(MAX_SUM, answer)
print(answer)
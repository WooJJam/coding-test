import sys
input = sys.stdin.readline
N = int(input())
V = list(map(int, input().split()))
answer = V[-1]
for i in range(len(V)-2, -1, -1):
    if answer % V[i]:
        m = answer // V[i] + 1
        answer = V[i] * m
print(answer)
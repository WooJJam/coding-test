import sys
input = sys.stdin.readline

M = int(input())
p = list(map(int, input().split()))
down = 0
up = 0
answer = 0
for i in range(M):
    if i<M-1 and p[i] > p[i+1]:
        up = 0
        down += 1

    elif i<M-1 and p[i] < p[i+1]:
        down = 0
        up += 1
    answer = (max(answer, max(up, down)))

print(answer+1)
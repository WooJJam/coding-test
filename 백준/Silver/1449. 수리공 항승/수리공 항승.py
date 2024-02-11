import sys
input = sys.stdin.readline
N,L = map(int, input().split())
pos = list(map(int, input().split()))
pos.sort(reverse=True)
answer = 0
i = 0
for _ in range(N):
    for j in range(i+1, N):
        if pos[i] - pos[j] < L:
            continue
        else:
            i = j
            answer += 1
            break
print(answer+1)
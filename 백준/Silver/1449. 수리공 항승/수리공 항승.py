import sys
input = sys.stdin.readline
N,L = map(int, input().split())
pos = list(map(int, input().split()))
pos.sort(reverse=True)
answer = 0
start = 0
end = start + 1
while end < N:
    if pos[start] - pos[end] < L:
        end += 1
        continue
    else:
        answer += 1
        start = end
print(answer + 1)
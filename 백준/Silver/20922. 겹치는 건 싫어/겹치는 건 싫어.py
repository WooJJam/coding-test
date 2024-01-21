import sys
input = sys.stdin.readline
N, K = map(int, input().split())
arr = list(map(int, input().split()))
count = [0] * 100_001
start = 0
end = start
check = 0
answer = 0
for start in range(N):
    while end < N:
        if count[arr[end]] == K:
            break
        count[arr[end]] += 1
        check += 1
        end += 1
    if end != N:
        if count[arr[end]] == K:
            answer = max(answer, check)
            count[arr[start]] -= 1
            check -= 1
    if end == N:
        answer = max(answer, check)
        break
print(answer)
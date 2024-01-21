import sys
input = sys.stdin.readline
N, K = map(int, input().split())
arr = list(map(int, input().split()))
count = [0] * 100_001
start = 0
end = start
answer = 0
for start in range(N):
    while end < N:
        if count[arr[end]] < K:
            count[arr[end]] += 1
            end += 1
        else:
            count[arr[start]] -= 1
            break
        answer = max(answer, end-start)
print(answer)
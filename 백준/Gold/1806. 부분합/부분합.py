import sys
input = sys.stdin.readline
N, S = map(int, input().split())
Sum = 0
end = 0
count = 0
INF = int(10e9)
answer = INF
arr = list(map(int, input().split()))
for start in range(N):
    while Sum < S and end < N:
        Sum += arr[end]
        end += 1
    if Sum >= S:
        answer = min(answer, (end-start))
        count = 0
    Sum -= arr[start]
print(0 if answer == INF else answer)
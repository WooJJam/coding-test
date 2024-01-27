import sys
input = sys.stdin.readline
n, k = map(int, input().split())
arr = []
for _ in range(n):
    arr.append(list(map(int, input().split())))
ice = [0]*1000001
for i in range(n):
    ice[arr[i][1]] = arr[i][0]
next = 2*k + 1
result = sum(ice[:next])
answer = result
for i in range(next, 1000001):
    result += (ice[i] - ice[i-next])
    answer = max(answer, result)
print(answer)
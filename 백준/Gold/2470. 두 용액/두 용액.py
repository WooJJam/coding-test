import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
arr.sort()
INF = int(10e9)
value = INF
start = 0
end = N-1
answer = [0] * 2
while start < end:
    result = arr[start] + arr[end]
    if abs(result) < value:
        value = abs(result)
        answer[0] = arr[start]
        answer[1] = arr[end]
    if result == 0:
        break
    elif result < 0:
        start += 1
    else:
        end -= 1
print(*answer)
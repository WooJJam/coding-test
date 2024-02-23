import sys
input = sys.stdin.readline
N, K = map(int, input().split())
cables = []
for _ in range(N):
    cables.append(int(input()))

def getCableLength(length):
    cut = 0
    for i in range(len(cables)):
        cut += (cables[i] // length)
    return cut

def binarySearch():
    start = 1
    end = max(cables)
    answer = 1
    while start <= end:
        mid = (start + end) // 2
        count = getCableLength(mid)
        if count >= K:
            answer = mid
            start = mid + 1
        else:
            end = mid -1
    print(answer)
binarySearch()
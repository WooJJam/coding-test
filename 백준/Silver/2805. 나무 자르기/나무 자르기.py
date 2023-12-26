import sys
N, M = map(int,sys.stdin.readline().split())
tree = list(map(int,sys.stdin.readline().split()))
def binarySearch():
    start = 1
    end = 2000000000
    answer = 0
    while(start<=end):
        result = 0
        mid = (start+end)//2
        for i in range(len(tree)):
            if tree[i] > mid:
                result += (tree[i] - mid)
        if result == M:
            return mid
        elif result < M:
            end = mid - 1
        else:
            answer = mid
            start = mid + 1
    return answer
print(binarySearch())
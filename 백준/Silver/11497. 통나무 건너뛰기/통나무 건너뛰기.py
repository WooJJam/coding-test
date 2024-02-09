import sys
input = sys.stdin.readline

def get_level(height):
    level = 0
    for i in range(N-1):
        level = max(abs(height[i] - height[i+1]), level)
    return level
answer = []
T = int(input())
for _ in range(T):
    N = int(input())
    height = [0] * N
    arr = list(map(int, input().split()))
    arr.sort()
    index = N//2
    height[index] = arr[-1]
    num = 0
    for i in range(N-2, -1, -1):
        if num < 0 :
            num = abs(num) + 1
        else:
            num += 1
            num *= -1
        index += num
        height[index] = arr[i]
    print(get_level(height))
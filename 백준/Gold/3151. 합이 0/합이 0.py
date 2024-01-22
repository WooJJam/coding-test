import sys, bisect
from collections import Counter

input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
arr.sort()
cnt_ = Counter(arr)
answer = 0
for first in range(N):
    second = first + 1
    third = N-1
    while second < third:
        result = arr[first] + arr[second] + arr[third]
        if result > 0:
            third -= 1
        elif result < 0:
            second += 1
        else:
            if arr[second] == arr[third]:
                answer += (third - second)
            else:
                answer += cnt_[arr[third]]
                # third_left = bisect.bisect_left(arr, arr[third])
                # third_right = bisect.bisect_right(arr, arr[third])
                # print("!!", arr[first], arr[second], arr[third])
                # answer += third_right - third_left
                # print(arr[second], second, second_right)
            second += 1
            
print(answer)
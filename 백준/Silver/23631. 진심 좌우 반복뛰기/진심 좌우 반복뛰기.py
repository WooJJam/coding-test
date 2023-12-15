import sys
T = int(sys.stdin.readline())

def binary_search(start, end):
    while start <= end:
        mid = (start + end) // 2
        max = K * mid
        if mid % 2 :# 얘가 홀수라면?
            result = (K + max) * (mid // 2) + (K + max) // 2
            if result >= N :
                end = mid -1
            else:
                start = mid + 1
        else :
            result = (K + max) * (mid // 2)
            if result >= N :
                end = mid -1
            else:
                start = mid + 1
    return start

for _ in range(T):
    N, K = map(int, sys.stdin.readline().split())
    start = 0
    end = N
    pos = 0
    answer = binary_search(start, end)

    if answer % 2 : # 홀수
        pos = ((answer + 1) // 2) * K
        pos += N - 1 - (K * ((answer * (answer + 1) // 2)))
        print(pos, "R")
    else:
        pos = -K * ((answer + 1) // 2)
        pos -= N - 1 - (answer * (answer + 1) * K // 2)
        print(pos, "L")
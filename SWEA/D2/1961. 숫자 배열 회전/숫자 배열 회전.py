T = int(input())
import collections

def turn90():
    result = []
    for i in range(N):
        for j in range(N-1, -1, -1):
            result.append(arr[j][i])
    return result

def turn180():
    result = []
    for i in range(N-1 ,-1, -1):
        for j in range(N-1, -1, -1):
            result.append(arr[i][j])
    return result

def turn270():
    result = []
    for i in range(N-1, -1, -1):
        for j in range(N):
            result.append(arr[j][i])
    return result


for test_case in range(1, T+1):
    N = int(input())
    arr = []
    for _ in range(N):
        arr.append(list(map(int, input().split())))

    result90 = turn90()
    result180 = turn180()
    result270 =turn270()

    j = 0
    k = 0
    t = 0
    print(f"#{test_case}")
    for i in range(N):
        for _ in range(N):
            print(result90[j], end="")
            j+=1
        print(" ", end="")
        for _ in range(N):
            print(result180[k], end="")
            k+=1
        print(" ", end="")
        for _ in range(N):
            print(result270[t], end="")
            t+=1
        print()
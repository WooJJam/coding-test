import sys

T = int(sys.stdin.readline())
sum = [0] * T

for i in range(T):
    N = int(sys.stdin.readline())
    price = list(map(int, sys.stdin.readline().split()))
    max = 0
    result = 0

    for j in range(len(price)-1, -1, -1):
        if price[j] >= max :
            max = price[j]
            continue
        else :
            result += max - price[j] 
    
    sum[i] = result

for i in range(len(sum)) :
    print(sum[i])
import sys
input = sys.stdin.readline
N = int(input())
coin = list(map(int, input().split()))
answer = 0
sell = coin[-1]
for i in range(N-2, -1, -1):
    buy = coin[i]
    if sell < buy:
        sell = buy
    else:
        answer += sell - buy
print(answer)
import sys

N, K = map(int, sys.stdin.readline().split())

money = []

for _ in range(N):
    money.append(int(sys.stdin.readline()))
money.sort(reverse=True)

result = 0
for coin in money:
    result += K//coin
    K %= coin

print(result)
n, k = map(int, input().split())
coin = []
dp = [0] * (k+1)
dp[0] = 1

def dynamic():
    for c in coin:
        for i in range(c, k+1):
            dp[i] = dp[i] + dp[i - c]

for _ in range(n):
    coin.append(int(input()))
dynamic()

print(dp[k])
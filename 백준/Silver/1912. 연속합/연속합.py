N = int(input())
number = list(map(int, input().split()))
dp = [0 for _ in range(N)]
dp[0] = number[0]

def dynamic(x):
    for i in range(x, N):
        dp[i] += max(number[i], dp[i-1]+number[i])
dynamic(1)
print(max(dp))

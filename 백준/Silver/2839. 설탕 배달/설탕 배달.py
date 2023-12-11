def dynamic(n):
    for i in range(6, n+1):
        if n % 5 == 0:
            dp[i] = dp[i-5] + 1
        elif dp[i-3] <= 0 or dp[i-5] <= 0:
            dp[i] = 1 + (max(dp[i-3], dp[i-5]))
        else:
            dp[i] = 1 + (min(dp[i-3], dp[i-5]))
    return dp[n]
x = int(input())
dp = [-1] * 5001
dp[3] = dp[5] = 1
answer = dynamic(x)
print(-1 if answer <= 0 else answer)
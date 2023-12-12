def dynamic(x):
    for i in range(3,x+1):
        dp[i] = dp[i-1] + dp[i-2]
    return dp[x]
dp = [0] * 91
dp[1] = 1
dp[2] = 1
n = int(input())
print(dynamic(n))
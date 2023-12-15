def dynamic(x):
    for i in range(3, x+1):
        dp[i] = dp[i-1] + dp[i-2]
    return dp[x]
N = int(input())
dp = [0] * 1001
dp[1] = 1
dp[2] = 2
print(dynamic(N)%10007)
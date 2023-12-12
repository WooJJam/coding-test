def dynamic(x):
    for i in range(3, x+1):
        if not i % 3 :
            if not i % 2 :
                dp[i] = 1 + min(dp[i//3], dp[i//2], dp[i-1])
            else:
                dp[i] = 1 + min(dp[i//3], dp[i-1])
        elif not i % 2:
            dp[i] = 1 + min(dp[i//2], dp[i-1])
        else:
            dp[i] = 1 + dp[i-1]
    return dp[x]

N = int(input())
dp = [0] * (10**6 +1)
dp[1] = 0
dp[2] = 1
print(dynamic(N))
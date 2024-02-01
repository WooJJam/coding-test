def solution(n):
    dp = [0] * 5_001
    dp[1] = 0
    dp[2] = 3
    for i in range(3, n+1):
        if i % 2 == 0:
            dp[i] = (3 * dp[i-2] + (sum(dp[1: i-3]) * 2) + 2) % 1_000_000_007
        else:
            dp[i] = 0
    return dp[n]
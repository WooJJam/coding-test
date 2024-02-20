def solution(n):
    return dynamic(n)[n] % 1234567

def dynamic(x):
    
    dp = [0] * 2_001
    dp[1] = 1
    dp[2] = 2
    
    for i in range(3, x+1):
        dp[i] = (dp[i-1] + dp[i-2]) % 1234567
    return dp
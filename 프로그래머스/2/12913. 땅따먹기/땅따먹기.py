answer = 0
def solution(land):
    dp = [[0 for _ in range(len(land[0]))] for _ in range(len(land))]
    for i in range(4):
        dp[0][i] = land[0][i]
    
    return dynamic(dp, land)
    
def dynamic(dp, land):
    for i in range(1, len(dp)):
        for j in range(len(dp[0])):
            dp[i][j] = max(dp[i-1][j+1:] + dp[i-1][:j]) + land[i][j]
    return max(dp[-1]) 
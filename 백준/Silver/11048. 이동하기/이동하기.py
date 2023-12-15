import sys
n, m  = map(int, sys.stdin.readline().split())
candy = []
dp = [[0 for _ in range(m)] for _ in range(n)]
for _ in range(n):
    candy.append(list(map(int, sys.stdin.readline().split())))

def dynamic():
    for i in range(n):
        for j in range(m):
            if i == j == 0:
                continue
            if i > 0 and j > 0:
                dp[i][j] = candy[i][j] + max(dp[i-1][j], dp[i][j-1])
            elif i > 0:
                dp[i][j] = candy[i][j] + dp[i-1][j]
            elif j > 0:
                dp[i][j] = candy[i][j] + dp[i][j-1]
    return dp[n-1][m-1]

dp[0][0] = candy[0][0]
print(dynamic())
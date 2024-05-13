N = int(input())

color = [] * N
dp = [[0 for _ in range(3)] for _ in range(N)]
def dynamic(x):
    for i in range(x, N):
        for j in range(3):
            if j == 0:
                dp[i][j] = min(dp[i-1][1], dp[i-1][2]) + color[i][j]
            elif j == 1:
                dp[i][j] = min(dp[i-1][0], dp[i-1][2]) + color[i][j]
            else:
                dp[i][j] = min(dp[i-1][0], dp[i-1][1]) + color[i][j]
for _ in range(N):
    color.append(list(map(int, input().split())))
answer = int(10e9)
dp[0][0] = color[0][0]
dp[0][1] = color[0][1]
dp[0][2] = color[0][2]
dynamic(1)
print(min(dp[N-1]))
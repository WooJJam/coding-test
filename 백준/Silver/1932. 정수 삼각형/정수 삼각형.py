N = int(input())
triangle = [[] for _ in range(501)]
dp = [[0 for _ in range(501)] for _ in range(501)]

def dynamic(x):
    for i in range(x, N):
        for j in range(i+1):
            if i == j:
                dp[i][j] = dp[i-1][j-1] + triangle[i][j]
            elif j == 0:
                dp[i][j] = dp[i-1][0] + triangle[i][0]
            else:
                dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]

for i in range(N):
    triangle[i] = list(map(int, input().split()))
dp[0][0] = triangle[0][0]

dynamic(1)
print(max(dp[N-1]))
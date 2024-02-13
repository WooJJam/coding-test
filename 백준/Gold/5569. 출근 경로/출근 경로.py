import sys
input = sys.stdin.readline

w, h = map(int, input().split()) # 가로, 세로
dp = [[[[0 for _ in range(2)] for _ in range(2)] for _ in range(101)] for _ in range(101)]
# [x좌표(가로)] [y좌표(세로)] [현재 방향 오 or 아래][꺽었는지 유무]
# 3번째 Index가 0 -> 오른쪽, 1 -> 아래
# 4번째 index가 0 -> 꺽지않음, 1 -> 꺽음

for i in range(2, w+1):
    dp[i][1][0][0] = 1

for i in range(2, h+1):
    dp[1][i][1][0] = 1

def dynamic():
    for i in range(2, w+1):
        for j in range(2, h+1):
            # i,j 좌표이고 오른쪽으로 교차로를 돌지 않은 경우
            dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][0][1]) % 100000
            # i,j 좌표이고 오른쪽으로 이미 교차로를 돈 경우
            # 이전에는 교차로를 돌지 않았으며 교차로를 돌았기 때문에 방향은 반대
            dp[i][j][0][1] = (dp[i-1][j][1][0]) % 100000
            # i,j 좌표이고 아래쪽이며 교차로를 돌지 않은 경우
            dp[i][j][1][0] = (dp[i][j-1][1][0] + dp[i][j-1][1][1]) % 100000
            # i,j 좌표이고 아래쪽이며 이미 교차로를 돈 경우
            # 이전에는 교차로를 돌지 않았으며 교차로를 돌았기 때문에 방향은 반대
            dp[i][j][1][1] = (dp[i][j-1][0][0]) % 100000
    return (dp[w][h][0][0] + dp[w][h][0][1] + dp[w][h][1][0] + dp[w][h][1][1]) % 100000

print(dynamic())
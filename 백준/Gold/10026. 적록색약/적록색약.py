N = int(input())
area = []
import sys
sys.setrecursionlimit(10**7)
for i in range(N):
    area.append(list(map(str, input().rstrip())))
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
answer = 0
answer2 = 0
visited = [[False for _ in range(N)] for _ in range(N)]
visited2 = [[False for _ in range(N)] for _ in range(N)]
def dfs1(x, y, color): # x좌표, y 좌표, 현재 색깔 (R, G, B)
    visited[x][y] = True

    for i in range(4):
        nextX = dx[i] + x
        nextY = dy[i] + y
        if 0 <= nextX < N and 0 <= nextY < N and not visited[nextX][nextY] and area[nextX][nextY] == color:
            dfs1(nextX, nextY, color)

def dfs2(x, y, color): # x좌표, y 좌표, 현재 색깔 (R, G, B)

    visited2[x][y] = True

    for i in range(4):
        nextX = dx[i] + x
        nextY = dy[i] + y
        if 0 <= nextX < N and 0 <= nextY < N and not visited2[nextX][nextY]:
            if (color == "R" or color =="G") and (area[nextX][nextY] == "R" or area[nextX][nextY] == "G"): # R or Green
                dfs2(nextX, nextY, color)
            elif color == "B" and area[nextX][nextY] == "B":
                dfs2(nextX, nextY, color)

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            answer += 1
            dfs1(i, j, area[i][j])
        if not visited2[i][j]:
            # print(i,j)
            answer2 += 1
            dfs2(i, j, area[i][j])

print(answer, answer2)
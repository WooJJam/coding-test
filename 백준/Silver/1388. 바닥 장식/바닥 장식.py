import sys

N, M = map(int, sys.stdin.readline().split())

deco = []
visited = [[False for _ in range(M)] for _ in range(N)]

for _ in range(N):
    deco.append(list(sys.stdin.readline().strip()))
cnt = 0

def dfs(x,y):
    visited[x][y] = True
    if deco[x][y] == '-':
        if y < M-1 and deco[x][y+1] == '-' :
            dfs(x, y+1)
        else :
            return
    if deco[x][y] == '|':
        if x < N-1 and deco[x+1][y] == '|':
            dfs(x+1, y)
        else :
            return

for i in range(N):
    for j in range(M):
        if visited[i][j] == False:
            cnt += 1
            dfs(i, j)

print(cnt)
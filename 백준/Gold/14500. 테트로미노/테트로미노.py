import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

N, M = map(int, input().split())
graph = []
dx = [-1,0,1,0]
dy = [0,1,0,-1]
visited = [[False for _ in range(M)] for _ in range(N)]
# ㅜ, ㅏ, ㅗ, ㅓ -> 4개는 예외 따로 체크해보자.
ex = [[0,0,0,1], [0,1,2,1], [0,0,0,-1], [0,1,2,1]]
ey = [[0,1,2,1], [0,0,0,1], [0,1,2,1], [0,0,0,-1]] 

for _ in range(N):
    graph.append(list(map(int, input().split())))
result = 0

def dfs(x, y, count, value):
    global result, visited
    value += graph[x][y]
    count += 1

    if count >= 4 :
        result = max(result, value)
        return
    
    for i in range(4):
        nextX = dx[i] + x
        nextY = dy[i] + y
        if 0 <= nextX < N and 0 <= nextY < M and not visited[nextX][nextY]:
            visited[x][y] = True
            dfs(nextX, nextY, count, value)
            visited[x][y] = False

def check_exshape(x, y):
    global result
    for i in range(4):
        value = 0
        count = 0
        for j in range(4):
            nextX = ex[i][j] + x
            nextY = ey[i][j] + y
            if 0 <= nextX < N and 0 <= nextY < M:
                value += graph[nextX][nextY]
                count += 1
            else:
                break
        if count == 4:
            result = max(result, value)

for i in range(N):
    for j in range(M):
        dfs(i,j,0,0)
        check_exshape(i,j)
print(result)
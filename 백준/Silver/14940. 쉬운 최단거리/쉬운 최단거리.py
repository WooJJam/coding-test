import sys
from collections import deque

input = sys.stdin.readline
dist = 0
N, M = map(int, input().split())
visited = [[False for _ in range(M)] for _ in range(N)]
arr = []
res = [[-1] *M for _ in range(N)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]
queue = deque([])
for i in range(N):
    arr.append(list(map(int, input().split())))
repeat = True
for i in range(N):
    for j in range(M):
        if arr[i][j] == 2:
            x = i 
            y = j
            repeat = False
    if not repeat:
        break

def bfs(x,y):
    queue.append([x,y])
    visited[x][y] = True
    res[x][y] = 0

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nextX = x + dx[i]
            nextY = y + dy[i]

            if 0<= nextX < N and 0<= nextY < M and not visited[nextX][nextY]:
                if arr[nextX][nextY] == 0 :
                    visited[nextX][nextY] = True
                    res[nextX][nextY] = 0
                elif arr[nextX][nextY] == 1:
                    visited[nextX][nextY] = True
                    res[nextX][nextY] = res[x][y] + 1
                    queue.append([nextX, nextY])
    
bfs(x,y)

for i in range(N):
    for j in range(M):
        if arr[i][j] == 0:
            print(0, end=" ")
        else:
            print(res[i][j], end=" ")
    print()
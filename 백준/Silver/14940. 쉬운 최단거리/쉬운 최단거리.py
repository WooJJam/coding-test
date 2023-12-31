import sys
from collections import deque

input = sys.stdin.readline
dist = 0
N, M = map(int, input().split())
visited = [[False for _ in range(M)] for _ in range(N)]
arr = []
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

def bfs(x,y,dist):
    queue.append([x,y,dist])
    visited[x][y] = True
    while queue:
        x, y, dist = queue.popleft()
        if arr[x][y]:
            arr[x][y] = dist
        
        for i in range(4):
            nextX = x + dx[i]
            nextY = y + dy[i]

            if 0<= nextX < N and 0<= nextY < M and arr[nextX][nextY] != 0 and not visited[nextX][nextY]:
                queue.append([nextX, nextY, dist+1])
                visited[nextX][nextY] = True

bfs(x,y, dist)

for i in range(N):
    for j in range(M):
        if arr[i][j] == 1 and not visited[i][j]:
            arr[i][j] = -1
            print(arr[i][j], end=' ')
        else: print(arr[i][j], end=' ')
    print()
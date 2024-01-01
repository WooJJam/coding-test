import sys
from collections import deque
queue = deque([])
input = sys.stdin.readline
N,M = map(int, input().split())
visited = [[False for _ in range(M)] for _ in range(N)]

arr = []
dist = 1
dx = [-1,0,1,0]
dy = [0,1,0,-1]

for i in range(N):
    arr.append(list(map(str, input().strip())))

def bfs(x, y, dist):
    queue.append([x,y,dist])
    visited[x][y] = True

    while queue:
        x, y, dist = queue.popleft()
        arr[x][y] = dist
        for i in range(4):
            nextX = x+dx[i]
            nextY = y+dy[i]
            if 0<= nextX < N and 0 <= nextY < M and not visited[nextX][nextY]:
                if arr[nextX][nextY] == '0':
                    visited[nextX][nextY] = True
                elif arr[nextX][nextY] == '1':
                    queue.append([nextX, nextY, dist+1])
                    visited[nextX][nextY] = True
bfs(0,0,dist)
print(arr[N-1][M-1])
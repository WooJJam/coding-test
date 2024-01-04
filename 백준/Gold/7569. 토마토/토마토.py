import sys
from collections import deque
input = sys.stdin.readline
queue = deque([])
M,N,H = map(int, input().split())
tomato = []
dist = 0
visited = [[[False for _ in range(M)] for _ in range(N)] for _ in range(H)]
for _ in range(H):
    floor = []
    for _ in range(N):
        floor.append(list(map(int, input().split())))
    tomato.append(floor)
dx = [0, 0, 0, 0, 1, -1]
dy = [-1, 0, 1, 0, 0, 0]
dz = [0, 1, 0, -1, 0, 0]
for i in range(H):
    for j in range(N):
        for k in range(M):
            if tomato[i][j][k] == 1:
                queue.append([i,j,k,dist])
                visited[i][j][k] = True
            elif tomato[i][j][k] == -1:
                visited[i][j][k] = True

def bfs():
    global dist
    while queue:
        x, y, z, d = queue.popleft()
        for i in range(6):
            nextX = dx[i] + x
            nextY = dy[i] + y
            nextZ = dz[i] + z
            if 0<= nextX < H and 0<= nextY < N and 0<= nextZ < M and tomato[nextX][nextY][nextZ] == 0 and not visited[nextX][nextY][nextZ]:
                queue.append([nextX, nextY, nextZ, d+1])
                dist = d+1
                tomato[nextX][nextY][nextZ] = dist
                visited[nextX][nextY][nextZ] = True
    return dist

dist = bfs()

for i in range(H):
    for j in range(N):
        for k in range(M):
            if tomato[i][j][k] == 0:
                print(-1)
                exit()

print(dist)
import sys
from collections import deque
input = sys.stdin.readline
N, M = map(int, input().split())
visited = [[False for _ in range(N)] for _ in range(M)]
# 서, 북, 동, 남
dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]
arr = []
groupNum = 0
room_size = [[0 for _ in range(N)] for _ in range(M)]
room_group = [[0 for _ in range(N)] for _ in range(M)]
for _ in range(M):
    arr.append(list(map(int, input().split())))

def bfs(x, y):
    global groupNum
    group = []
    count = 1
    q = deque()
    q.append([x,y])
    visited[x][y] = True
    group.append([x, y])

    while q:
        x, y = q.popleft()

        for i in range(4):
            if arr[x][y] & (1<<i) == 0:
                nextX = dx[i] + x
                nextY = dy[i] + y

                if 0 <= nextX < M and 0 <= nextY < N and not visited[nextX][nextY]:
                    count += 1
                    visited[nextX][nextY] = True
                    q.append([nextX, nextY])
                    group.append([nextX, nextY])
    for x, y in group:
        room_size[x][y] = count
        room_group[x][y] = groupNum

    return count
size = 0
for i in range(M):
    for j in range(N):
        if not visited[i][j]:
            groupNum += 1
            count = bfs(i,j)
            size = max(size, count)
maxRoom = 0
for i in range(M):
    for j in range(N):
        for k in range(4):
            if arr[i][j] & (1<<k) == (1<<k): # 벽이 있다면?
                nextI = dx[k] + i
                nextJ = dy[k] + j
                if 0 <= nextI < M and 0 <= nextJ < N:
                    if room_group[i][j] != room_group[nextI][nextJ]:
                        maxRoom = max(maxRoom, room_size[i][j] + room_size[nextI][nextJ])
print(groupNum)
print(size)
print(maxRoom)
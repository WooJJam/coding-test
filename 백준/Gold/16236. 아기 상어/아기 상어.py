import sys, heapq
from collections import deque
input = sys.stdin.readline
N = int(input())
space = []
q = []
shark = (0,0)
dx = [-1, 0 ,1, 0]
dy = [0, 1, 0, -1]
level = 2
eat = 0
queue = deque()
for _ in range(N):
    space.append(list(map(int, input().split())))

for i in range(N):
    for j in range(N):
        if space[i][j] == 9:
            shark = (i,j)
            space[i][j] = 0

def bfs(x, y):
    visited = [[-1] * N for _ in range(N)]
    visited[x][y] = 0
    queue.append([x,y])

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nextX = dx[i] + x
            nextY = dy[i] + y

            if 0 <= nextX < N and 0 <= nextY < N:
                if space[nextX][nextY] <= level and visited[nextX][nextY] == -1:
                    visited[nextX][nextY] = visited[x][y] + 1
                    queue.append([nextX, nextY])
    
    return visited
x, y = shark[0], shark[1]
answer = 0
while True:
    visited = bfs(x,y)
    distance = int(10e9)
    for i in range(N):
        for j in range(N):
            if visited[i][j] != -1 and 1<= space[i][j] < level:
                if distance > visited[i][j]:
                    distance = visited[i][j]
                    x, y = i,j

    if distance == int(10e9):
        print(answer)
        break
    else:
        answer += distance
        space[x][y] = 0
        eat += 1
    
    if eat == level:
        eat = 0
        level += 1

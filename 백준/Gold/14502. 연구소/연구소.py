import sys, copy
from collections import deque

input = sys.stdin.readline
N, M = map(int , input().split())
queue = deque([])
graph = []
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
virus = []
answer = 0
for _ in range(N):
    graph.append(list(map(int, input().split())))

# visited = [[False for _ in range(N)] for _ in range(M)]

def bfs():
    global answer
    count = 0
    for i in range(len(virus)):
        queue.append([virus[i][0], virus[i][1]])
    copy_graph = copy.deepcopy(graph)

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nextX = x + dx[i]
            nextY = y + dy[i]

            if 0<= nextX < N and 0<= nextY < M and copy_graph[nextX][nextY] == 0:
                queue.append([nextX, nextY])
                copy_graph[nextX][nextY] = 2

    for i in range(N):
        for j in range(M):
            if copy_graph[i][j] == 0:
                count += 1
    
    answer = max(answer, count)

def get_virus():
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 2:
                virus.append([i,j])

def make_wall(count):
    if count == 3:
        bfs()
        return
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                graph[i][j] = 1
                make_wall(count+1)
                graph[i][j] = 0

get_virus()
make_wall(0)
print(answer)
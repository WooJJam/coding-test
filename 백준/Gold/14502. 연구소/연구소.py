import sys, copy
from itertools import combinations
from collections import deque

input = sys.stdin.readline
N, M = map(int , input().split())
queue = deque([])
graph = []
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
answer = 0
for _ in range(N):
    graph.append(list(map(int, input().split())))

def bfs(copy_graph):
    global answer
    result = 0
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 2:
                queue.append([i,j])

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
                result+=1
    answer = max(answer, result)

safe_list = []
for i in range(N):
    for j in range(M):
        if graph[i][j] == 0:
            safe_list.append((i,j))

for c in combinations(safe_list, 3):
    copy_graph = copy.deepcopy(graph)
    for x, y in c:
        copy_graph[x][y] = 1
    bfs(copy_graph)

print(answer)
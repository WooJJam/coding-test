import sys
from collections import deque
input = sys.stdin.readline

dx = [1, 2, 3, 4, 5, 6]

def bfs(start):
    queue = deque()
    
    queue.append((start, 0))
    visited[start] = True

    while queue:
        pos, cnt = queue.popleft()

        if pos == 100:
            print(cnt)
            break

        for i in range(6):
            nextX = dx[i] + pos

            if 0 < nextX <= 100 and not visited[nextX]:
                if nextX in ladder_keys:
                    nextX = ladder[nextX]
                if nextX in snake_keys:
                    nextX = snake[nextX]
                visited[nextX] = True
                queue.append((nextX, cnt+1))

N, M = map(int, input().split())

graph = [[(j*10)+(i+1) for i in range(10)] for j in range(10)]
ladder = {}
ladder_keys = []
snake = {}
snake_keys = []
visited = [False for _ in range(101)]

for i in range(N):
    x, y = map(int, input().split())
    ladder[x] = y
    ladder_keys.append(x)

for i in range(M):
    u, v = map(int, input().split())
    snake[u] = v
    snake_keys.append(u)

bfs(1)
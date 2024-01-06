from collections import deque

n, m = map(int, input().split())

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, -1, -1, -1, 0, 1, 1, 1]
graph = [[0] * 101 for _ in range(101)]
vis = [[False] * 101 for _ in range(101)]

def BFS(yy, xx):
    global n, m
    q = deque()
    q.append((yy, xx))
    vis[yy][xx] = True

    while q:
        y, x = q.popleft()

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= m or ny >= n:
                continue

            if graph[yy][xx] < graph[ny][nx]:
                global isPeak
                isPeak = False

            if vis[ny][nx]:
                continue

            if graph[yy][xx] != graph[ny][nx]:
                continue

            q.append((ny, nx))
            vis[ny][nx] = True

cnt = 0

for i in range(n):
    row = list(map(int, input().split()))
    for j in range(m):
        graph[i][j] = row[j]

for i in range(n):
    for j in range(m):
        if vis[i][j]:
            continue

        if not graph[i][j]:
            continue

        isPeak = True
        BFS(i, j)

        if isPeak:
            cnt += 1

print(cnt)

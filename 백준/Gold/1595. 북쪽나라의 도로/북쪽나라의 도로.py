graph = [[] for _ in range(10001)]
visited = [False] * 10001
answer = 0
edge = 0
cur = 0

while True:
    try:
        a, b, length = map(int, input().split())
        graph[a].append((b, length))
        graph[b].append((a, length))
        edge += 1
    except :
        break

def dfs(i, length):
    global cur
    cur = max(cur, length)
    visited[i] = True
    for point in graph[i]:
        if not visited[point[0]]:
            dfs(point[0], length + point[1])

for i in range(1, edge+1):
    visited = [False] * 10001
    length = 0
    dfs(i, 0)
    answer = max(answer, cur)

print(answer)
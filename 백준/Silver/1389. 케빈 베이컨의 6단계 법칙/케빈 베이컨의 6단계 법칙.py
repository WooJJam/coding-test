from collections import deque

def initVisited():
    visited = [0] * (N + 1)
    return visited

def bfs(start, count):
    visited = initVisited()
    queue.append((start, count))

    while queue:
        s, c = queue.popleft()

        for i in graph[s]:
            if visited[i] > 0:
                continue

            visited[i] = c + 1
            queue.append((i, c + 1))

    return sum(visited)


N, M = map(int, input().split())

graph = [[] for _ in range(N+1)]
visited = [0] * (N + 1)

queue = deque([])

for i in range(M):
    n,m = map(int, input().split())
    graph[n].append(m)
    graph[m].append(n)

min = int(1e9)

for i in range(1, N+1):
    count = bfs(i, 0)

    if min > count:
        min = count
        answer = i
    
print(answer)

import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())
graph = [[]for _ in range(n+1)]
visited = [False] * (n+1)
result = 0
weight = 0
start = 1
for i in range(1,n):
    p, c, w = map(int, input().split())
    graph[p].append((c,w))
    graph[c].append((p,w))

def dfs(x, w):
    visited[x] = True
    global result, start
    if result < w:
            result = w
            start = x
    for i in graph[x]:
        if not visited[i[0]]:
            dfs(i[0], w + i[1])

dfs(start, weight)
visited = [False] * (n+1)
dfs(start, weight)
print(result)
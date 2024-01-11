import sys
input = sys.stdin.readline

V = int(input())
graph = [[] for _ in range(100_001)]
visited = [False] * 100_001
result = 0
index = 1
for _ in range(V):
    line = list(map(int, input().split()))
    for i in range(1, len(line), 2):
        if line[i] == -1:
            break
        graph[line[0]].append((line[i], line[i+1]))

def dfs(start, w):
    visited[start] = True
    global result, index

    if result < w:
            result = w
            index = start
    for i in graph[start]:
        result = max(result, w)
        if not visited[i[0]]:
            dfs(i[0], i[1]+w)

dfs(index, 0)
visited = [False] * 100_001
dfs(index, 0)
print(result)
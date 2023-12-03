import sys
from collections import deque

N,M,V = map(int, sys.stdin.readline().split())

arr = []
node= [[]for _ in range(N+1)]
for _ in range(M):
    arr.append(list(map(int, sys.stdin.readline().split())))

for i in range(M):
    node[arr[i][0]].append(arr[i][1])
    node[arr[i][1]].append(arr[i][0])

for value in node:
    value.sort()
visited = [False] * (N + 1)

def dfs(x):
    if visited[x] == False:
        visited[x] = True
        print(x, end=' ')

        for value in node[x]:
            dfs(value)

def bfs(x):
    visited[x] = True
    queue = deque([x])

    while queue:
        v = queue.pop()
        print(v, end=' ')
        for value in node[v]:
            if not visited[value]:
                queue.appendleft(value)
                visited[value] = True
        
dfs(V)
visited = [False] * (N + 1)
print()
bfs(V)
print()
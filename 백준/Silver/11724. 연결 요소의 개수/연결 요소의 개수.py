import sys
from collections import deque
input = sys.stdin.readline
answer = 0

N,M = map(int, input().split())
visited = [False] * (N+1)
node = [[]for _ in range(N+1)]

def bfs(x):
    queue = deque([x])
    visited[x] = True
    global answer
    answer += 1
    while queue:
        pos = queue.popleft()
        for i in node[pos]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
                
for i in range(M):
    u, v = map(int, input().split())
    node[u].append(v)
    node[v].append(u)
    
for i in range(1, len(visited)):
    if not visited[i]:
        bfs(i)
        
print(answer)
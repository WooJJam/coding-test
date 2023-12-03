import sys
from collections import deque 

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
arr = []
node = [[]for _ in range(N+1)]
queue = deque()

for _ in range(M):
    arr.append(list(map(int, sys.stdin.readline().split())))
visited = [False] * (N+1)

for i in range(M) :
    node[arr[i][0]].append(arr[i][1])
    node[arr[i][1]].append(arr[i][0])

def bfs(x) :
    queue.appendleft(x)
    visited[x] = True
    sum = 0
    while queue:
        v = queue.popleft()
        for i in node[v]:
            if not visited[i]:
                queue.appendleft(i)
                sum += 1
                visited[i] = True
    return sum

print(bfs(1))
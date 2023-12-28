import sys
from collections import deque
input = sys.stdin.readline

M,N = map(int, input().split()) # M:가로, N:세로
visited = [[False for _ in range(M+1)]for _ in range(N+1)]
queue = deque()

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
arr=[]
for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))

for i in range(N):
    for j in range(M):
        if arr[i][j] == 1:
            queue.append([i,j])

def bfs():
    time = 0
    while queue:
        x = []
        y = []
        while range(len(queue)):
            a, b = queue.popleft()
            y.append(a)
            x.append(b)
            # print(a,b)
        
        for i in range(len(x)):
            for j in range(4):
                tempY = y[i] + dy[j]
                tempX = x[i] + dx[j]
            
                if 0 <= tempY < N and 0 <= tempX < M and arr[tempY][tempX] == 0 and not visited[tempY][tempX]:
                    visited[tempY][tempX] = True
                    arr[tempY][tempX] = 1
                    queue.appendleft([tempY, tempX])
        time+=1
    return time -1

time = bfs()

for i in arr:
    if 0 in i:
        print(-1)
        exit()
print(time)
import sys
from collections import deque
input = sys.stdin.readline

N,K = map(int, input().split())
visited = [False]*100001
queue = deque()
time = 0

def moveA(x):
    if 0 <= x <= 100000:
        return x-1
    else:
        return -1

def moveB(x):
    if 0 <= x < 100000:
        return x+1
    else:
        return -1

def moveC(x):
    if 2*x > 100000:
        return -1
    else: 
        return 2*x

def bfs(x, time):
    queue.append([x,time])

    while queue:
        num, time = queue.popleft()
        if num == K:
            print(time)
            exit()
        else:
            time += 1
            a = moveA(num)
            if a >= 0 and not visited[a]:
                visited[a] = True
                queue.append([a,time])
            b = moveB(num)
            if b >= 0 and not visited[b]:
                visited[b] = True
                queue.append([b,time])
            c = moveC(num)
            if c >= 0 and not visited[c]:
                visited[c] = True
                queue.append([c,time])

bfs(N, time)
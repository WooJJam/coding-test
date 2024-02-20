from collections import deque

def solution(maps):
    N = len(maps)
    M = len(maps[0])
    start = []
    lever = []
    flag = True
    for i in range(N):
        for j in range(M):
            if maps[i][j] == 'S':
                start.append((i,j))
                flag = False
            if maps[i][j] == 'L':
                lever.append((i,j))
            
    leverTime = bfs(maps, start, 0, "L")
    endTime = bfs(maps, lever, leverTime, "E")
    
    if leverTime == -1 or endTime == -1:
        return -1
    return endTime

def bfs(maps, start, time, end):
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    visited = [[False for _ in range(len(maps[0]))] for _ in range(len(maps))]
    x, y = start.pop()
    queue = deque()
    queue.append([x,y, time])
    visited[x][y] = True
    while queue:
        x, y, time = queue.popleft()
        
        for i in range(4):
            nextX = dx[i] + x
            nextY = dy[i] + y
            
            if 0<= nextX < len(maps) and 0 <= nextY < len(maps[0]) and maps[nextX][nextY] != "X" and not visited[nextX][nextY]:
                if maps[nextX][nextY] == end:
                    return time+1
                visited[nextX][nextY] = True
                queue.append([nextX, nextY, time+1])
    return -1
                
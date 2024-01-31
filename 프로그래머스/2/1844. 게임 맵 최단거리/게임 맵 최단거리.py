from collections import deque
def solution(maps):
    visited = [[False for _ in range(101)] for _ in range(101)]
    check = [[0 for _ in range(101)] for _ in range(101)]
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    
    def bfs(x, y):
        q = deque()
        q.append([x,y])
        visited[x][y] = True
        check[x][y] += 1
        while q:
            x, y = q.popleft()
            
            for i in range(4):
                nextX = dx[i] + x
                nextY = dy[i] + y
                
                if 0 <= nextX < len(maps) and 0<= nextY < len(maps[0]) and maps[nextX][nextY] != 0 and not visited[nextX][nextY]:
                    q.append([nextX, nextY])
                    visited[nextX][nextY] = True
                    check[nextX][nextY] = check[x][y] + 1
    bfs(0,0)
    print(check)
    if not visited[len(maps)-1][len(maps[0])-1]:
        return -1
    else:
        return check[len(maps)-1][len(maps[0])-1]

    
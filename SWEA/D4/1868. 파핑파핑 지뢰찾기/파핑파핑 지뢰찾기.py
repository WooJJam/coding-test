from collections import deque

T = int(input())

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]

def bfs(i, j):
    q = deque()
    q.append([i,j])
    visited[i][j] = True
    bomb[i][j] = 'O'

    while q:
        x, y = q.popleft()
        if isBomb(x, y):
            continue
        else:
            for i in range(8):
                nextX = dx[i] + x
                nextY = dy[i] + y

                if 0 <= nextX < N and 0 <= nextY < N and not visited[nextX][nextY] and bomb[nextX][nextY] == '.':
                    visited[nextX][nextY] = True
                    bomb[nextX][nextY] = 'O'
                    q.append([nextX, nextY])

def isBomb(x, y):
    for i in range(8):
            nextX = dx[i] + x
            nextY = dy[i] + y

            if 0 <= nextX < N and 0 <= nextY < N and not visited[nextX][nextY] and bomb[nextX][nextY] == '*':
                return True   
    return False

for test_case in range(1, T+1):
    N = int(input())
    bomb = []
    for _ in range(N):
        bomb.append(list(map(str, input().rstrip())))

    visited = [[False for _ in range(N)] for _ in range(N)]
    answer = 0
    pos = []
    for i in range(N):
        for j in range(N):
            if bomb[i][j] == ".":
                if isBomb(i,j):
                    continue
                else:
                    answer += 1
                    pos.append([i,j])
                    bfs(i,j)
    for i in range(N):
        for j in range(N):
            if bomb[i][j] == '.':
                answer += 1
    
    print(f"#{test_case} {answer}")
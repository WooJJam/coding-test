import sys
sys.setrecursionlimit(10**7)
N = int(input())
apart = []
dx = [-1, 0, 1, 0]
dy = [0, 1, 0 ,-1]
visited = [[False for _ in range(N)] for _ in range(N)]

def dfs(x, y, count):

    global check
    for i in range(4):
        nextX = dx[i] + x
        nextY = dy[i] + y

        if 0 <= nextX < N and 0 <= nextY < N and not visited[nextX][nextY] and apart[nextX][nextY] == 1:
            check += 1
            apart[nextX][nextY] = count
            visited[nextX][nextY] = True
            dfs(nextX, nextY, count)
    
for _ in range(N):
    apart.append(list(map(int, input().rstrip())))
count = 0
_check = []
for i in range(N):
    for j in range(N):
        if not visited[i][j] and apart[i][j] == 1:
            count += 1
            check = 1
            visited[i][j] = True
            apart[i][j] = count
            dfs(i, j, count)
            _check.append(check)
_check.sort()
print(count)
for i in _check:
    print(i)


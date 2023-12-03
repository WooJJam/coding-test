import sys
sys.setrecursionlimit(10000)

T = int(sys.stdin.readline())

def dfs(y, x, field, visited, M, N):
    visited[y][x] = True
    if 0 < y and field[y-1][x] == 1 and visited[y-1][x] == False :
        dfs(y-1, x, field, visited, M, N)
    if x < M-1 and field[y][x+1] == 1 and visited[y][x+1] == False:
        dfs(y,x+1,field,visited,M,N)
    if y < N-1 and field[y+1][x] == 1 and visited[y+1][x] == False:
        dfs(y+1,x,field,visited,M,N)
    if 0 < x and field[y][x-1] == 1 and visited[y][x-1] == False:
        dfs(y,x-1,field,visited,M,N)

for _ in range(T):
    M, N, K = map(int, sys.stdin.readline().split())
    arr = []
    cnt = 0
    field = [[0 for _ in range(M)]for _ in range(N)]
    visited = [[False for _ in range(M)]for _ in range(N)]
    for i in range(K):
        arr.append(list(map(int, sys.stdin.readline().split())))
    for i in arr:
        field[i[1]][i[0]] = 1
    for i in range(N):
        for j in range(M):
            if field[i][j] == 1 and visited[i][j] == False:
                cnt +=1
                dfs(i, j, field, visited, M, N)
    
    print(cnt)
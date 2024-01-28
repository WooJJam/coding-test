import sys, copy
input = sys.stdin.readline
sys.setrecursionlimit(10**7)
N,M = map(int, input().split())
arr = []
cctv = []

move = [
    [],
    [[0], [1], [2], [3]],
    [[0,2],[1,3]],
    [[0,1],[1,2],[2,3],[3,0]],
    [[3,0,1],[0,1,2],[1,2,3],[2,3,0]],
    [[0,1,2,3]]
]

dx = [-1,0,1,0]
dy = [0,1,0,-1]

for i in range(N):
    arr.append(list(map(int, input().split())))

def search(x,y, move,temp):
    for i in move:
        nextX = x
        nextY = y
        while True:
            nextX += dx[i]
            nextY += dy[i]
            if 0 <= nextX < N and 0 <= nextY < M:
                if temp[nextX][nextY] == 6:
                    break
                if temp[nextX][nextY] == 0:
                    temp[nextX][nextY] = -1
            else:
                break
answer = int(10e9)
def dfs(cnt, arr):
    global answer
    if cnt == len(cctv):
        answer = min(answer, get_zero(arr))
        return
    temp = copy.deepcopy(arr)
    x, y, cctv_num = cctv[cnt]
    for i in move[cctv_num]:
        search(x,y,i,temp)
        dfs(cnt+1, temp)
        temp = copy.deepcopy(arr)

def get_zero(temp):
    zero = 0
    for i in temp:
        zero += i.count(0)
    return zero

for i in range(N):
    for j in range(M):
        if arr[i][j] != 0 and arr[i][j] != 6:
            cctv.append([i,j,arr[i][j]])
dfs(0, arr)
print(answer)
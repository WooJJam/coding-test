import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)
graph = []
stack = []
for _ in range(19):
    graph.append(list(map(int, input().split())))

def dfs(i,j, stone):

    for k in range(4):
        nextX = i + dx[k]
        nextY = j + dy[k]
        count = 1
        while 0 <= nextX <= 18 and 0 <= nextY <= 18 and graph[nextX][nextY] == stone:
            count += 1

            if count == 5:
                prevX = dx[k] * -1 + i
                prevY = dy[k] * -1 + j
                nextX += dx[k]
                nextY += dy[k]

                if 0 <= prevX <= 18 and 0 <= prevY <= 18 and graph[prevX][prevY] == stone:
                    break
                if 0 <= nextX <= 18 and 0 <= nextY <= 18 and graph[nextX][nextY] == stone:
                    break
                print(stone)
                print(i+1, j+1)
                exit(0)
            nextX += dx[k]
            nextY += dy[k]

# 우, 우 아래, 아래, 우 위
dx = [0, 1, 1, -1] 
dy = [1, 1, 0, 1]

for i in range(19):
    for j in range(19):
        if graph[i][j] != 0:
            dfs(i,j, graph[i][j])

print(0)
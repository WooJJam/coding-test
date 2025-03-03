import sys, heapq

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

def solve(i, j):
    q = []
    distance[i][j] = 0
    heapq.heappush(q, (i, j, 0))

    while q:
        y, x, cost = heapq.heappop(q)
        if cost > distance[y][x]: # 현재 비용이 해당 지점의 비용보다 크다면 방문처리
            continue

        for i in range(4):
            nextY = dy[i] + y
            nextX = dx[i] + x
            if (0 <= nextY < M and 0 <= nextX < N): # 범위내에 있다면 이동 가능

                if distance[nextY][nextX] > miro[nextY][nextX] + cost:
                    distance[nextY][nextX] = miro[nextY][nextX] + cost
                    heapq.heappush(q, (nextY, nextX, miro[nextY][nextX] + cost))

input = sys.stdin.readline

N, M = map(int, input().split())
miro = [] * M
MAX = int(10e9)

distance = [[MAX for _ in range(N)] for _ in range(M)]

for i in range(M):
    miro.append(list(map(int, input().rstrip())))

solve(0,0)
print(distance[M-1][N-1])
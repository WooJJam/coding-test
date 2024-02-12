import sys
from collections import deque
input = sys.stdin.readline

# N, L, R
# N 만큼 반복
# L명 이상 R명 이하 -> 하루동안 문 염
# 국경선 다 열리면 인구이동
# 인접한 카만 이동 가능, 그 나라는 하루동안 연합
# 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
# 연합을 해체하고, 모든 국경선을 닫는다.

# 3 5 10
# 10 15 20
# 20 30 25
# 40 22 10

# 5명이상 10명 이하
# 10 : 15 : 20
# . .  --   . .
# 20 : 30 : 25    -> 10+ 15+ 20+ 20+ 30+ 25 = 120 // 6 == 20 
# -------------
# 40 | 22 | 10    -> 40 + 22 + 10 = 72//3 = 24

# 20 | 20 | 20
# ------------
# 20 | 20 | 20
# ------------
# 24 | 24 | 24  -- > 20 + 20 + 20+ 24 + 24+ 24 == 132 // 6 = 22

N,L,R = map(int, input().split())
population = []
dx = [-1, 0, 1, 0]
dy = [0, 1, 0 ,-1]
pos = []
for _ in range(N):
    population.append(list(map(int, input().split())))
day = 0
def bfs(x,y, move, area, visited):
    global pos, day
    visited[x][y] = True
    q = deque()
    q.append([x,y])
    pos.append([x,y])
    while q:
        x, y = q.popleft()
        for i in range(4):
            nextX = dx[i] + x
            nextY = dy[i] + y
            if 0 <= nextX < N and 0 <= nextY < N and not visited[nextX][nextY]:
                if L <= abs(population[nextX][nextY] - population[x][y]) <= R:
                    move += population[nextX][nextY]
                    visited[nextX][nextY] = True
                    area += 1
                    q.append([nextX, nextY])
                    pos.append([nextX,nextY])
    return move, area
area = 0
while True:
    day += 1
    flag = False
    visited = [[False for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                move, area = bfs(i, j, population[i][j], 1, visited)
                if len(pos) >= 2:
                    flag = True
                    person = move // area
                    for x,y in pos:
                        population[x][y] = person
                pos = []
    if not flag:
        break
print(day-1)
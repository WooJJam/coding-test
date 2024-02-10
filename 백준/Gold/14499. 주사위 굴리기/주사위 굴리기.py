import sys
input = sys.stdin.readline

N, M, x, y, k = map(int, input().split())
graph = []
dice = [0,0,0,0,0,0]

# 동, 서, 북, 남
dx=[0, 0, -1, 1]
dy=[1, -1, 0, 0]

for _ in range(N):
    graph.append(list(map(int, input().split())))
order = list(map(int, input().split()))
def set_dice(dice, direct):
    up, back, right, left, front, down = dice
    if direct == 1: # 동쪽으로 이동
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = left, back, up, down, front, right
    elif direct == 2: # 서쪽으로 이동
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = right, back, down, up, front, left
    elif direct == 3: # 북쪽으로 이동
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = front, up, right, left, down, back
    else: # 남쪽으로 이동
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = back, down, right, left, up, front


answer = []
for direct in order:
    x += dx[direct-1]
    y += dy[direct-1]
    if 0 <= x < N and 0 <= y < M:
        set_dice(dice, direct)
        if graph[x][y] == 0:
            graph[x][y] = dice[5]
        else:
            dice[5] = graph[x][y]
            graph[x][y] = 0
        print(dice[0])
    else:
        x -= dx[direct-1]
        y -= dy[direct-1]
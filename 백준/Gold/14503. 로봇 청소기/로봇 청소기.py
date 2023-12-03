import sys

N, M = map(int, sys.stdin.readline().split())
cur_y, cur_x, direction = map(int, sys.stdin.readline().split())
a,b = cur_x, cur_y
room = []
for _ in range(N):
    room.append(list(map(int,sys.stdin.readline().split())))
dx = [0,1,0,-1]
dy = [-1,0,1,0]
cnt = 0
while(True):
    if room[cur_y][cur_x] == 0:
        room[cur_y][cur_x] = 2
        cnt+=1
    clean = False
    for i in range(4): # 주위에 청소할 곳이 있는지 확인
        if room[cur_y+dy[i]][cur_x+dx[i]] == 0 :
            clean = True
            break
    if clean: # 청소해야할 곳이 있다면 반시계로 회전
        direction = (direction + 3) % 4 
        if room[cur_y+dy[direction]][cur_x+dx[direction]] == 0: # 현재 바라보는 방향에서 앞칸이 청소가능한지 확인
            cur_x += dx[direction]
            cur_y += dy[direction]
    else : # 청소해야할 곳이 없다
        if room[cur_y-dy[direction]][cur_x-dx[direction]] == 1: # 후진해야하는데 벽이다?
            break
        else: # 벽이 아니면 후진
            cur_x -= dx[direction]
            cur_y -= dy[direction]
print(cnt)
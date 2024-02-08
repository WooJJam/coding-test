import sys
input = sys.stdin.readline
N = int(input())
room = [[0 for _ in range(N)] for _ in range(N)]
student = []
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
for _ in range(N**2):
    student.append(list(map(int, input().split())))

def checkLikePosition(likeStudent):
    maxFriends = -1
    maxBlank = -1
    for i in range(N):
        for j in range(N):
            friends = 0
            blankCheck = 0
            if room[i][j] == 0:
                for k in range(4):
                    nextX = i + dx[k]
                    nextY = j + dy[k]
                    if 0 <= nextX < N and 0 <= nextY < N:
                        if room[nextX][nextY] == 0:
                            blankCheck += 1
                        elif room[nextX][nextY] in likeStudent:
                            friends += 1
                if maxFriends < friends: # 최대 좋아하는 친구보다 지금 좋아하는 친구가 더 많더면 제일 우선 순위임
                    maxFriends = friends
                    maxBlank = blankCheck
                    x = i
                    y = j
                elif maxFriends == friends: # 좋아하는 친구의 갯수가 같다면 빈칸의 수가 많은애가 제일 우선
                    if maxBlank < blankCheck:
                        maxBlank = blankCheck
                        x = i
                        y = j
                else: # 좋아하는 친구의 갯수가 기존에게 더 많다면 검사할 필요 없음
                    continue

    return x,y

for i in student:
    likeStudent = i[1:]
    x, y = checkLikePosition(likeStudent)
    room[x][y] = i[0]

like = 0
for i in range(N):
    for j in range(N):
        cnt = 0
        for k in range(4):
            nextX = dx[k] + i
            nextY = dy[k] + j
            if 0 <= nextX < N and 0 <= nextY < N:
                for k in student:
                    s = k[0]
                    likeStudent = k[1:]
                    if s == room[i][j] and room[nextX][nextY] in likeStudent:
                        cnt += 1
        if cnt == 0:
            like += 0
        elif cnt == 1:
            like += 1
        elif cnt == 2:
            like += 10
        elif cnt == 3:
            like += 100
        else:
            like += 1000
print(like)

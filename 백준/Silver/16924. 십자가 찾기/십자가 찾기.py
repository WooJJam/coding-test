import sys, copy
input = sys.stdin.readline
N,M = map(int, input().split())
board = []
for _ in range(N):
    board.append(list(map(str, input().rstrip())))
answer = []
temp = copy.deepcopy(board)
for i in range(N):
    for j in range(M):
        if board[i][j] == "*":
            up = down = i
            left = right = j
            size = 0
            while True:
                up -= 1
                down += 1
                right += 1
                left -= 1
                if up >= 0 and down < N and right < M and left >= 0 and board[up][j] == board[down][j] == board[i][right] == board[i][left] == "*":
                        temp[up][j] = temp[down][j] = temp[i][right] = temp[i][left] = temp[i][j] = "."
                        size += 1
                        answer.append([i+1, j+1, size])
                else:
                    break
for i in range(N):
    for j in range(M):
        if temp[i][j] == "*":
            print(-1)
            exit()
print(len(answer))
for x,y,z in answer:
        print(x, y, z)
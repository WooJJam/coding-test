T = int(input())

dx = [-1, 0, 1, 0]
dy = [0, 1, 0 ,-1]

def dfs(x, y, number):
    global answer
    if len(number) == 7:
        if number not in search:
            answer += 1
            search.add(number)
        return
    
    for i in range(4):
        nextX = dx[i] + x
        nextY = dy[i] + y

        if 0 <= nextX < 4 and 0 <= nextY < 4:
            dfs(nextX, nextY, number+board[nextX][nextY])

for test_case in range(1, T+1):
    board = []
    search = set()
    answer = 0
    for _ in range(4):
        board.append(list(map(str, input().split())))
    
    for i in range(4):
        for j in range(4):
            dfs(i,j, "")
    print(f"#{test_case} {answer}")

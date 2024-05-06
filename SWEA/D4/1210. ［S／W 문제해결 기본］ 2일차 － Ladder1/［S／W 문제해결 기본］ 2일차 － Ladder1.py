def dfs(x, y):
    visited[x][y] = True
    if x == 0:
        return y
    else:
        # 왼쪽
        if 0 <= y -1 < 100 and ladder[x][y-1] == 1 and not visited[x][y-1]:
            return dfs(x, y-1)
        elif 0 <= y + 1 < 100 and ladder[x][y+1] == 1 and not visited[x][y+1]:
            return dfs(x, y+1)
        elif 0 <= x-1 < 100 and ladder[x-1][y] == 1 and not visited[x-1][y]:
            return dfs(x-1, y)

for test_case in range(1, 11):
    _ = int(input())
    posX, posY = 0, 0
    ladder = []
    for _ in range(100):
        ladder.append(list(map(int, input().split())))
    visited = [[False for _ in range(100)] for _ in range(100)]
    for i in range(100):
        if ladder[99][i] == 2:
            posX = 99
            posY = i
    answer = dfs(posX, posY)
    print(f"#{test_case} {answer}")
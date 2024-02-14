import sys, copy
input = sys.stdin.readline
MAP = []
temp = []
R,C = map(int, input().split())
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
for _ in range(R):
    MAP.append(list(map(str, input().rstrip())))
answer = []
temp = copy.deepcopy(MAP)
row = []
col = []
for i in range(R):
    for j in range(C):
        rand = 0
        if MAP[i][j] == "X":
            for k in range(4):
                nextX = dx[k] + i
                nextY = dy[k] + j
                if 0 > nextX or R <= nextX or 0 > nextY or C <= nextY:
                    rand += 1
                elif 0 <= nextX < R and 0 <= nextY < C:
                    if MAP[nextX][nextY] == ".":
                        rand += 1
            if rand >= 3:
                temp[i][j] = "."
            else:
                row.append(i)
                col.append(j)

if row:
    max_row = max(row)
    min_row = min(row)
    max_col = max(col)
    min_col = min(col)
    for i in range(min_row, max_row + 1):
        for j in range(min_col, max_col + 1):
            print(temp[i][j], end="")
        print()
else:
    print("X")
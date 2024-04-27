
#sys.stdin = open("input.txt", "r")
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.

def dfs(x, y, num):
    if snail[x][y] == 0:
        snail[x][y] = num+1
    
        # 오른쪽
        if 0 <= y < N-1 and snail[x][y+1] == 0:
            dfs(x, y+1, snail[x][y])

        # 아래
        if 0<= x < N-1 and snail[x+1][y] == 0:
            dfs(x+1, y, snail[x][y])

        # 왼쪽
        if 0 < y <= N-1 and snail[x][y-1] == 0:
            dfs(x, y-1, snail[x][y])

        # 위로
        if 0 < x <= N-1 and snail[x-1][y] == 0:
            dfs(x-1, y, snail[x][y])
    else:
        return

test_num = 1
for test_case in range(1, T + 1):
    N = int(input())
    
    snail = [[0 for _ in range(N)] for _ in range(N)]
    dfs(0,0,0)
    print(f"#{test_num}")
    test_num+=1
    for i in range(N):
        for j in range(N):
            print(snail[i][j], end=" ")
        print()
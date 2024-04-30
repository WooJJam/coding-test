T = int(input())

def check(x):
    for i in range(x):
        # 행 체크, 대각선 체크
        if row[i] == row[x] or (abs((row[i]) - (row[x]))) == abs(i - x):
            return False
    return True

def dfs(x):
    global answer 
    if x == N:
        answer += 1
        return
    else:
        for i in range(N):
            row[x] = i
            if check(x):
                dfs(x+1)

for testCase in range(1, T+1):
    N = int(input())
    row = [0] * N
    answer = 0
    dfs(0)
    print(f"#{testCase} {answer}")
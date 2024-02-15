import sys
from itertools import combinations
# N: 세로선, M: 사다리 갯수, H: 가로선
N, M, H = map(int, input().split())
ladder = [[False] * N for _ in range(H)] # 특정 지점 방문 여부 체크
for _ in range(M):
    # b번 세로선과 b+1 세로선을 a 점선 위치에서 연결
    a, b = map(int, input().split())
    ladder[a-1][b-1] = True

def check() :
    for i in range(N):
        start = i
        for j in range(H):
            if ladder[j][start]:
                start += 1
            elif start > 0 and ladder[j][start-1]:
                start -= 1
        if start != i: 
            return False
    return True
answer = 4

def dfs(count, x, y): # 사다리 갯수, 가로선, 세로선
    global answer

    if check():
        answer = min(answer, count) # 사다리의 시작점과 도착점이 일치하면 조건 만족
        return
    
    if count >= 3 or count >= answer: 
        # 사다리의 갯수가 3개일경우 아래 조건에 의해 4가 되므로 return
        # count가 현재 정답보다 크거나 같다면 더이상 볼필요 x
        return
    for i in range(x, H): # 행
        if i == x: # 탐색해야할 곳이 같은 행일 경우
            now = y
        else:
            now = 0 # 탬색해야할 곳이 다음 행일 경우 열은 0으로 초기화
        for j in range(now, N): # 열
            if j < N - 1 and not ladder[i][j] and not ladder[i][j+1]: # 오른쪽에 사다리가 존재하지 않는 경우
                if j > 0 and ladder[i][j-1]: # 왼쪽에 사다리가 있는 경우 무시
                    continue
                ladder[i][j] = True
                dfs(count + 1, i, j+2) # 사다리갯수 + 1, 현재 행, 탐색할 열
                ladder[i][j] = False

dfs(0, 0, 0)
print(answer if answer <=3 else -1)
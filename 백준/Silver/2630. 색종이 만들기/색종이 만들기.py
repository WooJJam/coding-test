import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**7)

N = int(input())
arr = []
white = 0
blue = 0

for _ in range(N):
    arr.append(list(map(int, input().split())))

def solution(x, y, N):
    global white, blue
    result = 0
    for i in range(y, y+N):
        for j in range(x, x+N):
            result += arr[i][j]

    if result == 0:
        white += 1
    elif result == (N*N):
        blue += 1
    else :
        N = N//2
        solution(x, y, N) # 왼쪽 위 
        solution(x+N, y, N) # 오른쪽 위 
        solution(x, y+N, N) # 왼쪽 아래
        solution(x+N, y+N, N) # 오른쪽 아래

x = 0
y = 0
solution(0, 0, N)
print(white)
print(blue)
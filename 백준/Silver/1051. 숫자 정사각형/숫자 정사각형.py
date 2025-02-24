import sys
input = sys.stdin.readline

def solve():
    
    answer = 1

    for i in range(N):
        for j in range(M):
            for k in range(M-1, j, -1):
                if (i+k-j < N and rectangle[i][j] == rectangle[i][k] == rectangle[i+k-j][j] == rectangle[i+k-j][k]):
                    area = (k-j+1) * (k-j+1)
                    answer = max(answer, area)
    
    return answer


N, M = map(int, input().split())
rectangle = []

for _ in range(N):
    rectangle.append(list(map(int, input().rstrip())))

answer = solve()
print(answer)
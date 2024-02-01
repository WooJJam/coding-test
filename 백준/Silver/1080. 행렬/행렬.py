import sys
input = sys.stdin.readline
N,M = map(int, input().split())
A = []
B = []
for _ in range(N):
    A.append(list(map(int, input().rstrip())))
for _ in range(N):
    B.append(list(map(int, input().rstrip())))

def convert(x, y, arr):
    for i in range(x, x+3):
        for j in range(y, y+3):
            arr[i][j] = 1 - arr[i][j]
answer = 0
for i in range(N-2):
    for j in range(M-2):
        if A[i][j] != B[i][j]:
            convert(i,j,A)
            answer += 1

for i in range(N):
    for j in range(M):
        if A[i][j] != B[i][j]:
            print(-1)
            exit()
print(answer)
import sys
input = sys.stdin.readline

def solve(x1, y1, x2, y2):
    return prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1] + prefix[x1-1][y1-1]


N, M = map(int, input().split())
table = [[0 for _ in range(N+1)] for _ in range(N+1)]
prefix = [[0 for _ in range(N+1)] for _ in range(N+1)]

for i in range(1, N+1):
    line = list(map(int, input().split()))
    for j in range(1, N+1):
        table[i][j] = line[j-1]

for i in range(1, N+1):
    for j in range(1, N+1):
        prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + table[i][j]

for i in range(M):
    x1, y1, x2, y2 = map(int, input().split())
    print(solve(x1,y1,x2,y2))
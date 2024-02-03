import sys
input = sys.stdin.readline
n, m = map(int, sys.stdin.readline().split())
arr = []
for i in range(n):
    arr.append(list(map(int, sys.stdin.readline().split())))

dir = [-1, 0, 1]

def dfs(x, y, d, low, answer):
    if x == n-1:
        return min(low, answer)
    for i in dir:
        if i != d:
            nextY = y+i
            if 0 <= x < n and 0 <= y + i < m:
                low = dfs(x+1, nextY, i, low, answer + arr[x+1][nextY])
    return low

low = int(10e9)
for y in range(m):
    low = min(dfs(0, y, 2, low, arr[0][y]), low)

print(low)
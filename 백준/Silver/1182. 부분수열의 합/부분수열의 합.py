import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

N, S = map(int, input().split())
arr = list(map(int, input().split()))
answer = 0

def dfs(depth, result):
    global answer
    if result == S and depth > 0:
        answer += 1
    
    if depth == N:
        return
    
    for i in range(depth, N):
        result += arr[i]
        dfs(i+1, result)
        result -= arr[i]
dfs(0, 0)
print(answer)

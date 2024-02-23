import sys
input = sys.stdin.readline
N, M = map(int, input().split())
answer = []
def dfs(k):
    if len(answer) == M:
        print(' '.join(map(str, answer)))
        return
    for i in range(k, N+1):
        answer.append(i)
        dfs(i)
        answer.pop()
dfs(1)
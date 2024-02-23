import sys
input = sys.stdin.readline
N, M = map(int, input().split())
visited = [False] * (N+1)
answer = []
def dfs(k):
    if len(answer) == M:
        print(' '.join(map(str, answer)))
        return
    for i in range(k, N+1):
        if visited[i]:
            continue
        visited[i] = True
        answer.append(i)
        dfs(i)
        answer.pop()
        visited[i] = False
dfs(1)
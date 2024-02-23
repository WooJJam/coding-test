import sys
input = sys.stdin.readline

N, M = map(int, input().split())

visited = [False] * (N+1)
answer = []
def dfs():
    if len(answer) == M:
        print(' '.join(map(str, answer)))
        return
    for i in range(1, N+1):
        if visited[i]:
            continue
        visited[i] = True
        answer.append(i)
        dfs()
        answer.pop()
        visited[i] = False
dfs()
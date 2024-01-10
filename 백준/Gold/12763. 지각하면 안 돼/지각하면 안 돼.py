import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
N = int(input())
T, M = map(int, input().split())
L = int(input())
graph = [[] for _ in range(N+1)]
# visited = [False] * (N+1)
INF = int(10e9)
result = INF
for _ in range(L):
    # 시작, 끝, 시간, 돈
    s, e, t, m = map(int, input().split())

    # 시작(s) -> 끝(e) 까지 가는데 필요한 시간(t), 돈(m)
    graph[s].append((e,t,m))
    graph[e].append((s,t,m))

def dfs(start, time, money):
    # global visited
    # visited[start] = True
    global result
    if start == N:
        result = min(result, money)
        return
    # i[0] = 끝, i[1] = 시간, i[2] = 돈
    for i in graph[start]:
        # if not visited[i[0]]:
        if T < i[1] + time or M < i[2] + money:
            continue
            # visited = [False] * (N+1)
        else:
            dfs(i[0], i[1]+time, i[2]+money)

dfs(1,0,0)
if result == INF :
    print(-1)
else:
    print(result)

# 5
# 180 4000
# 7
# 1 2 60 2000
# 1 4 120 4000
# 2 5 90 2000
# 3 1 120 1000
# 3 4 30 1500
# 3 5 40 4500
# 5 4 30 1000
# 3500

# 5
# 180 4000
# 7
# 1 2 60 4000
# 1 4 120 4000
# 2 5 90 2000
# 3 1 120 3000
# 3 4 30 1500
# 3 5 40 4500
# 5 4 30 1000
# -1
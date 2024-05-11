T = int(input())

def big_dfs(x):
    global count
    for i in big_graph[x]:
        if not visited[i]:
            visited[i] = True
            count += 1
            big_dfs(i)

def small_dfs(x):
    global count
    for i in small_graph[x]:
        if not visited[i]:
            visited[i] = True
            count += 1
            small_dfs(i)

for test_case in range(1, T+1):
    N = int(input()) # 사람의 수 (vertex)
    M = int(input()) # 키 비교 수 (edef)
    count = 0
    big_graph = [[] for _ in range(N+1)]
    small_graph = [[] for _ in range(N+1)]
    answer = 0
    for i in range(M):
        a, b = map(int, input().split()) # a -> b : a < b
        big_graph[a].append(b)
        small_graph[b].append(a)
    
    for i in range(1, N+1):
        count = 1
        visited=[False] * (N+1)
        visited[i] = True
        big_dfs(i)
        small_dfs(i)
        if count == N:
            answer += 1
    
    print(f"#{test_case} {answer}")
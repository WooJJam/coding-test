def dfs(x):    
    visited[x] = True
    
    if x == 99:
        return 1
    
    for i in graph[x]:
        if not visited[i]:
            if dfs(i) == 1:
                return 1
    return 0

for test_case in range(1, 11):
    n, l = map(int, input().split())
    graph =[[] for _ in range(100)]

    street = list(map(int, input().split()))
    for i in range(0, len(street) -1 , 2):
        graph[street[i]].append(street[i+1])
    visited = [False for _ in range(100)]

    print(f"#{test_case} {dfs(0)}")
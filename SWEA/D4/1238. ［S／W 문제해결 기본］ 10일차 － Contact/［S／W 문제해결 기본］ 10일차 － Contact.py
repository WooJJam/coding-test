import heapq
from collections import deque

def bfs(start):
    q = []
    heapq.heappush(q, (0, start))

    while q:
        count, start = heapq.heappop(q)

        for i in graph[start]:
            if not visited[i]:
                heapq.heappush(q, (count+1, i))
                visited[i] = True
    return start


for test_case in range(1, 11):
    L, S = map(int, input().split())
    graph = [[] for _ in range(101)]
    data = list(map(int, input().split()))
    visited = [False] * 101
    for i in range(0, L, 2):
        graph[data[i]].append(data[i+1])
    
    print(f"#{test_case} {bfs(S)}")
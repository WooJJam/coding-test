import sys
import heapq
input = sys.stdin.readline

N, D = map(int, input().split())
INF = int(10e9)

distance = [INF] * (D+1)

graph = [[] for _ in range(D+1)]

for i in range(D):
    graph[i].append([i+1, 1])

for i in range(N):
    start, end, weight = map(int, input().split())
    if end > D:
        continue
    graph[start].append([end, weight])

def dijkstra(x):
    q = []
    heapq.heappush(q , [0, x])

    while q:
        dist, now = heapq.heappop(q)
        if dist > distance[now]:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, [cost, i[0]])

dijkstra(0)
print(distance[D])
import sys, heapq
input = sys.stdin.readline

V, E = map(int, input().split())
K = int(input())
graph = [[] for _ in range(V+1)]
INF = int(10e9)
distance = [INF] * (V+1)
for _ in range(E):
    u,v,w = map(int, input().split())
    graph[u].append((v,w))

def dijkstra(start, w):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        w, start = heapq.heappop(q)

        if distance[start] < w:
            continue

        for i in graph[start]:
            cost = w + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(K, 0)
for i in range(1,len(distance)):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])
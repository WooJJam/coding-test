import sys, heapq
input = sys.stdin.readline
N, M, X = map(int , input().split())
INF = int(10e9)
graph = [[] for _ in range(N+1)]
reverse_graph = [[] for _ in range(N+1)]

for _ in range(M):
    s, e, t = map(int, input().split())
    graph[s].append([e,t])
    reverse_graph[e].append([s,t])
answer = 0

def dijkstra(start, graph):
    distance = [INF] * (N+1)
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue

        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    return distance

go = dijkstra(X, graph)
end = dijkstra(X, reverse_graph)
for i in range(1, N+1):
    answer = max(answer, go[i] + end[i])
print(answer)
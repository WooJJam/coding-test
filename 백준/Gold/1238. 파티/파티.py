import sys, heapq
input = sys.stdin.readline
N, M, X = map(int , input().split())
INF = int(10e9)
graph = [[] for _ in range(N+1)]

go_distance = [INF] * (N+1)
back_distance = [INF] * (N+1)

for _ in range(M):
    s, e, t = map(int, input().split())
    graph[s].append([e,t])
answer = 0

def dijkstra(start, distance):
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

for i in range(1, N+1):
    dijkstra(i, go_distance)
    dijkstra(X, back_distance)
    answer = max(answer, go_distance[X] + back_distance[i])
    go_distance = [INF] * (N+1)
    back_distance = [INF] * (N+1)
print(answer)
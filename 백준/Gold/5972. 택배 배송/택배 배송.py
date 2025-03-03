import sys
import heapq
input = sys.stdin.readline

def dijkstra(start):
    q = []
    distance[start] = 0
    heapq.heappush(q, (start, 0))
    while q:
        index, value = heapq.heappop(q) ## 헛간의 번호, 소의 갯수
        if distance[index] < value: # 해당 헛간까지의 소의 갯수가 현재 수의 갯수보다 적다면 이미 최소값
            continue

        for i, cost in graph[index]:
            cost += value
            if distance[i] > cost:
                distance[i] = cost
                heapq.heappush(q, (i, cost))

N, M = map(int, input().split())
MAX = int(10e9)
graph = [[] for _ in range(N+1)]
distance = [MAX] * (N+1)

for i in range(M):
    A,B,C = map(int, input().split())
    graph[A].append((B,C))
    graph[B].append((A,C))

dijkstra(1)
print(distance[N])
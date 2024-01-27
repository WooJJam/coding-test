import sys, heapq
input = sys.stdin.readline
T = int(input())
INF = sys.maxsize
def dijkstra(start, z):
    global M, path, ship
    q = []
    heapq.heappush(q,(z, start))
    ship[start] = 0
    path[0] = 0
    while q:
        dist, now = heapq.heappop(q)
        if ship[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < ship[i[0]]:
                ship[i[0]] = cost
                path[i[0]] = now
                heapq.heappush(q,(cost, i[0]))
caseCount = 1
for _ in range(T):
    N,M = map(int,input().split())
    graph = [[] for _ in range(M)]
    path = [-1 for _ in range(M)]
    ship = [INF] * (M+1)
    answer = []
    for _ in range(N):
        x,y,z = map(int, input().split())
        graph[x].append((y,z))
        graph[y].append((x,z))
    dijkstra(0, 0)
    index = M - 1
    answer = []
    if ship[index] == INF:
        answer.append(-1)
    else:
        answer.append(M-1)
        while index != 0:
            answer.append(path[index])
            index = path[index]
        answer.reverse()
    print(f"Case #{caseCount}:", end=' ')
    print(*answer, sep=' ')
    caseCount+=1
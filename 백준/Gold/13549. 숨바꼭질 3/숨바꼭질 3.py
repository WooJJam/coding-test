import sys, heapq
input = sys.stdin.readline
N, K = map(int, input().split())
if N == K :
    print(0)
    exit()
INF = int(10e9)
time = 0
distance = [INF] * (100_001)

def dijkstra(time, start):
    q = []
    heapq.heappush(q, (time, start))
    distance[start] = 0
    while q:
        time, start = heapq.heappop(q)
        if distance[start] < time:
            continue
        # 이동하는 범위를 계산하자
        for x in [(1, start+1), (1, start-1), (0, start*2)]:
            if 0<= x[1] <= 100_000:
                cur_time = time + x[0]
                if cur_time < distance[x[1]]:
                    distance[x[1]] = cur_time
                    heapq.heappush(q, (cur_time, x[1]))

dijkstra(time, N)
print(distance[K])
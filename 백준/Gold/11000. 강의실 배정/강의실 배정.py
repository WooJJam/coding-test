import sys, heapq
input = sys.stdin.readline
N = int(input())
lec = []
for _ in range(N):
    s, t = map(int, input().split())
    lec.append([s,t])
lec.sort(key=lambda x: x[0])

q = []
heapq.heappush(q, (lec[0][1]))

for i in range(1, N):
    if lec[i][0] < q[0]:
        heapq.heappush(q, (lec[i][1]))
    else:
        heapq.heappop(q)
        heapq.heappush(q, (lec[i][1]))
print(len(q))
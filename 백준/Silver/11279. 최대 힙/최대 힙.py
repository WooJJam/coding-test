import heapq, sys
N = int(sys.stdin.readline())
q = []
for _ in range(N):
    x = int(sys.stdin.readline())
    if not x:
        if not len(q):
            print(0)
        else:
            print(-heapq.heappop(q))
    else :
        heapq.heappush(q, -x)
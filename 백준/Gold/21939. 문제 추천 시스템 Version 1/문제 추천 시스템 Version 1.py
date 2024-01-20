import sys, heapq
input = sys.stdin.readline
N = int(input())
q = []
maxq=[]
problem = dict()
for _ in range(N):
    P, L = map(int, input().split())
    heapq.heappush(q, [L,P])
    heapq.heappush(maxq, [-L,-P])
    problem[P] = True
M = int(input())
for _ in range(M):
    command = list(map(str, input().split()))
    if command[0] == "add":
        P = int(command[1])
        L = int(command[2])
        while not problem[-maxq[0][1]]:
            heapq.heappop(maxq)
        while not problem[q[0][1]]:
            heapq.heappop(q)
        heapq.heappush(q, ([L,P]))
        heapq.heappush(maxq, ([-L,-P]))
        problem[P] = True
    elif command[0] == "recommend":
        x= int(command[1])
        if x == 1:
            while not problem[-maxq[0][1]]:
                heapq.heappop(maxq)
            print(-maxq[0][1])
        else:
            while not problem[q[0][1]]:
                heapq.heappop(q)
            print(q[0][1])
    elif command[0] == "solved":
        x = int(command[1])
        problem[x] = False
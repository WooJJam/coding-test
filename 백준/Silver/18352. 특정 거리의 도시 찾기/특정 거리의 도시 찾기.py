import sys
from collections import deque

def bfs(start):
    q = deque()
    q.append((start, 0))
    visited[start] = 0

    while q:
        index, dist = q.popleft()

        for i in graph[index]:
            if visited[i] < 0:
                q.append((i, dist+1))
                visited[i] = dist + 1

def get_answer(K):
    answer = []
    for i in range(len(visited)):
        if visited[i] == K:
            answer.append(i)

    answer.sort()
    
    if len(answer) > 0 :
        for i in answer:
            print(i)
    else:
        print(-1)

input = sys.stdin.readline

N, M, K, X = map(int, input().split())
MAX = int(10e9)
graph = [[] for _ in range(N+1)]
visited = [-1] * (N+1)
answer = []

for i in range(M):
    A,B = map(int, input().split())
    # A -> B 의 비용이 1이다.
    graph[A].append(B)

bfs(X)
get_answer(K)
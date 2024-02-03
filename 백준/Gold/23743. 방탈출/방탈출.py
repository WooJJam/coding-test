import sys
input = sys.stdin.readline


N, M = map(int, input().split())
parent = [0] * (N+1)
room = []

for _ in range(M):
    a, b, c = map(int, input().split())
    room.append([c,a,b])
t = (list(map(int, input().split())))

for i in range(N):
    room.append([t[i], 0, i+1])

for i in range(1, N+1):
    parent[i] = i

room.sort()
answer = 0

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    if a > b:
        parent[a] = b
    else:
        parent[b] = a
for r in room:
    c, a, b = r
    findA = find(parent, a)
    findB = find(parent, b)
    if findA != findB:
        union(parent, findA, findB)
        answer += c

print(answer)

# 3 3
# 1 2 10
# 1 3 10
# 2 3 10
# 1 1 1
# 3
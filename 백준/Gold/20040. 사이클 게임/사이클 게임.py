import sys
input = sys.stdin.readline
N, M = map(int, input().split())
parent = [0] * (N)

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    if a < b:
        parent[b] = a
    else: parent[a] = b

for i in range(N):
    parent[i] = i

for i in range(M):
    a, b = map(int, input().split())

    a = find(parent, a)
    b = find(parent, b)

    if a == b:
        print(i+1)
        exit()
    else:
        union(parent, a, b)
print(0)
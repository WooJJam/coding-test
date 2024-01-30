import sys
input = sys.stdin.readline
V, E = map(int, input().split())
parent = [0] * (V+1)

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

for i in range(1, V+1):
    parent[i] = i

graph = [] * V
for i in range(E):
    a, b, c = map(int, input().split())
    graph.append([c,b,a])

graph.sort()
answer = 0
for i in range(len(graph)):
    w, s, e = graph[i]
    findS = find(parent, s)
    findE = find(parent, e)
    if findS != findE:
        answer += w
        union(parent, findS, findE)
print(answer)
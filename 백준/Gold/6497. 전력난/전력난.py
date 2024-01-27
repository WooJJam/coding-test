import sys
input = sys.stdin.readline

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    x, y = find(x), find(y)
    if x > y:
        parent[x] = y
    else:
        parent[y] = x

while True:
    m, n = map(int, input().split())
    if m == 0 and n == 0:
        break
    parent = [i for i in range(m)]
    answer = 0
    edges = []
    for _ in range(n):
        x, y, z = map(int, input().split())
        edges.append((x, y, z))
    edges.sort(key=lambda x: x[2])
    for edge in edges:
        s, e, w = edge
        if find(s) == find(e): 
            answer += w
        else:
            union(s, e)
    print(answer)
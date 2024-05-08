T = int(input())

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    if a > b:
        parent[a] = b
    else:
        parent[b] = a

def setGraph():
    for i in range(N):
        for j in range(i+1, N):
            distance = (((X[i] - X[j])**2) + ((Y[i]-Y[j])**2))
            edges.append((distance, i, j))
    edges.sort()

def kruskal():
    answer = 0
    for edge in edges:
        cost, a, b = edge
        findA = find(a)
        findB = find(b)
        if findA != findB:
            union(findA, findB)
            answer += E * cost
    return round(answer)

for test_case in range(1, T+1):
    N = int(input())
    X = (list(map(int, input().split())))
    Y = (list(map(int, input().split())))
    E = float(input())
    edges = []
    headEdges=[]
    parent = [0] * N
    for i in range(N):
        parent[i] = i
    setGraph()
    print(f"#{test_case} {kruskal()}")
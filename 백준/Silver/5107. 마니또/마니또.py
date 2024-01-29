import sys
input = sys.stdin.readline

def find(parent, x) :
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, first, second):
    parent[second] = first 
tsetCase = 1

while True:
    cycle = 0
    T = int(input())
    if T == 0:
        break
    else:
        answer = []
        parent = {}
        name = []
        answer.append(tsetCase)
        tsetCase += 1
        for _ in range(T):
            f, s = map(str, input().split())
            name.append([f,s])
            parent[f] = f
            parent[s] = s
        for i in range(len(name)):
            a = find(parent, name[i][0])
            b = find(parent, name[i][1])
            if a == b:
                cycle+=1
            else:
                union(parent, a, b)
        answer.append(cycle)
    print(*answer)
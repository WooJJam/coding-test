import sys
input = sys.stdin.readline
N, W = map(int, input().split())
tree = [0] * (N+1)
for i in range(N-1):
    u, v = map(int, input().split())
    tree[u]+=1
    tree[v]+=1
leaf = 0
for i in range(2, N+1):
    if tree[i] == 1:
        leaf += 1
print(W/leaf)
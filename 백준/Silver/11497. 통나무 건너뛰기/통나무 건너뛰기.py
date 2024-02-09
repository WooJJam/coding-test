import sys
input = sys.stdin.readline
T = int(input())
for _ in range(T):
    N = int(input())
    tree = list(map(int, input().split()))
    tree.sort()
    level = 0
    for i in range(2, N):
        level = max(level, abs(tree[i]-tree[i-2]))
    print(level)
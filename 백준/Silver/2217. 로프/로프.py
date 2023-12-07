import sys
N = int(sys.stdin.readline())
k = []
for _ in range(N):
    k.append(int(sys.stdin.readline()))
k.sort()

result = 0
for i in range(N):
    if result < k[i] * (N-i):
        result = (k[i] * (N-i))
print(result)
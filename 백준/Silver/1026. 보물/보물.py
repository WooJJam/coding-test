import sys

N = int(sys.stdin.readline())
A = list(map(int,sys.stdin.readline().split()))
B = list(map(int,sys.stdin.readline().split()))

A.sort(reverse=False)
B.sort(reverse=True)
result = 0
for i in range(N):
    result+= A[i] * B[i]
print(result)
import sys
input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))
Sum = [0] * (len(A)+1)
for i in range(len(A)):
    Sum[i+1] = Sum[i] + A[i] 
M = int(input())
for _ in range(M):
    i, j = map(int, input().split())
    print(Sum[j] - Sum[i-1])
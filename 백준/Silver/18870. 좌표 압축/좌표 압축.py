import sys
input = sys.stdin.readline
N = int(input())
X = list(map(int, input().split()))
Y = sorted(set(X))
dic = {Y[i]: i for i in range(len(Y))}
for i in X:
    print(dic[i], end=' ')
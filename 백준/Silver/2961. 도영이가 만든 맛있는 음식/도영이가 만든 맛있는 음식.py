import sys
from itertools import combinations
input = sys.stdin.readline
N = int(input())
material = []
for _ in range(N):
    material.append(list(map(int,input().split())))

answer = 10e9

for i in range(N):
    for x in combinations(material, i+1):
        sour = 1
        bitter = 0
        for s,b in x:
            sour *= s
            bitter += b
        answer = min(answer, abs(sour - bitter))

print(answer)
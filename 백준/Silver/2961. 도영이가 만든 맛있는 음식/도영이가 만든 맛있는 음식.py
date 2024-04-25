import sys
import itertools
input = sys.stdin.readline
N = int(input())
material = []
for _ in range(N):
    material.append(list(map(int,input().split())))

answer = 10e9
sour = 0 # 신맛
bitter = 0 # 쓴맛
for i in range(N):
    for x in itertools.combinations(material, i+1):
        sour = 1
        bitter = 0
        for j in range(len(x)):
            sour *= x[j][0]
            bitter += x[j][1]
        answer = min(answer, abs(sour - bitter))

print(answer)
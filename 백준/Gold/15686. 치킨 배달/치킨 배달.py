import sys, copy
from itertools import combinations
input = sys.stdin.readline

N, M = map(int, input().split())
city = []
house = []
chicken = []
answer = int(10e9)
for _ in range(N):
    city.append(list(map(int, input().split())))

for i in range(N):
    for j in range(N):
        if city[i][j] == 1:
            house.append((i,j))
        elif city[i][j] == 2:
            chicken.append((i,j))

def solution(select):
    global answer
    dist = 0
    for i in range(len(house)): # 집 갯수만큼
        result = int(10e9)
        hx, hy = house[i]
        for j in range(len(select)): # 집 1개당 가능한 치킨집 갯수만큼 계산
            cx, cy = select[j]
            result = min(result, (abs(hx - cx) + abs(hy - cy)))
        else:
            dist += result
    answer = min(answer,dist)

for pos in combinations(chicken, M):
    select = []
    for x, y in pos:
        select.append((x,y))
    solution(select)

print(answer)
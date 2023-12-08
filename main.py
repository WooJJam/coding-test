import sys

T = int(sys.stdin.readline())
for _ in range(T):
    score = 1
    arr = [0] * 1000
    max_val = float('inf')
    index = 0
    point = [[] for _ in range(1000)]
    N = int(sys.stdin.readline())
    team = list(map(int, sys.stdin.readline().split()))

    for i in range(len(team)):
        arr[team[i]] += 1
    for i in team:
        if arr[i] >= 6:
            point[i].append(score)
            score += 1
    for i in range(len(point)):
        if len(point[i]) != 0:
            if max_val > sum(point[i][:4]):
                max_val = sum(point[i][:4])
                index = i
            elif max_val == sum(point[i][:4]):
                if point[index][4] > point[i][4]:
                    index = i
    print(index)
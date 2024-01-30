import sys
input = sys.stdin.readline

N, M, B = map(int, input().split())
earth = []
for _ in range(N):
    earth.append(list(map(int, input().split())))

answer = int(10e9)
height = 0
for i in range(257): # 256층까지 검사
    delete = 0
    use = 0
    for j in range(N):
        for k in range(M):
            if i < earth[j][k]: # 현재 층보다 earth의 층이 더 높다면?
                delete += (earth[j][k] - i) # 해당 층만큼 지워야함 ex) 140 200 -> 60층 지워야함
            else:
                use += i - earth[j][k]

    if use > delete + B:
        continue

    time = (delete * 2) + use
    if answer >= time:
        answer = time
        height = i

print(answer, height)
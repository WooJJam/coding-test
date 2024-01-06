import sys
input = sys.stdin.readline

N = int(input())

point=[]

for _ in range(N):
    pos, color =map(int,input().split())
    point.append([pos,color])

point.sort(key=lambda x: (x[1], x[0]))

answer=0

for i in range(N):
    result = 2 * 10**9 + 1
    if 0 <= i < N - 1 and point[i][1] == point[i + 1][1]:
        result = min(result,abs(point[i][0]-point[i+1][0]))
    if 0 < i < N and point[i][1] == point[i - 1][1]:
        result = min(result, abs(point[i][0] - point[i - 1][0]))
    if result == 2 * 10**9 + 1:
        continue
    answer += result
print(answer)
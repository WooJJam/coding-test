import sys
n, m = map(int,sys.stdin.readline().split())

answer = 0
subject = []
for i in range(n):
    p, l = map(int, sys.stdin.readline().split())
    point = list(map(int,sys.stdin.readline().split()))
    point.sort(reverse=True)
    if p < l:
        if m <= 0:
            break
        m -= 1
        answer += 1
    else:
        subject.append(point[l-1])

subject.sort()

for i in range(len(subject)):
    if m < subject[i]:
        break
    else:
        m -= subject[i]
        answer += 1
print(answer)
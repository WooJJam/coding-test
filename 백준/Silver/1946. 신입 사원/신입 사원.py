import sys

T = int(sys.stdin.readline())
sum = []

for _ in range(T) :
    member = []
    N = int(sys.stdin.readline())
    for j in range(N):
        member.append(list(map(int, sys.stdin.readline().split())))
    member.sort(reverse=False)

    result = 1
    grade = member[0][1]
    for j in range(1, N):
        if grade > member[j][1]:
            grade = member[j][1]
            result += 1
    sum.append(result)

for num in sum :
    print(num)
import sys
N = int(sys.stdin.readline())
grade = []
for _ in range(N):
    grade.append(int(sys.stdin.readline()))
answer = 0
grade.sort(reverse=False)
for i in range(N):
    answer += abs((i+1) - grade[i])
print(answer)
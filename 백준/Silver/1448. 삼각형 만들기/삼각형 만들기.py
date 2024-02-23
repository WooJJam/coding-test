import sys
input = sys.stdin.readline
N = int(input())
triangle = []
for _ in range(N):
    triangle.append(int(input()))
triangle.sort(reverse=True)
answer = -1
for i in range(N-2):
    if triangle[i] >= (triangle[i+1] + triangle[i+2]):
        continue
    else:
        answer = triangle[i] + triangle[i+1] + triangle[i+2]
        break
print(answer)
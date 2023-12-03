import sys
N = int(sys.stdin.readline())

height = (list(map(int, sys.stdin.readline().split())))
min = 10
result = []

def swap(k, t):
    temp = result[k]
    result[k] = result[t]
    result[t] = temp

for i in range(len(height)):
    for j in range(len(height)):
        if (i == height[j]):
            result.append(j)

for k in range(1, len(result)):
    cnt = 0
    for t in range(k):
        if(result[k] < result[t]):
            cnt += 1
        if(cnt > height[result[k]]):
            swap(k, t)

result = [x + 1 for x in result]
print(*result)
import sys
from collections import deque
input= sys.stdin.readline

N, K = map(int , input().split())
queue = deque()
for i in range(1, N+1):
    queue.append(i)
count = 1
answer = []
while queue:
    if count == K:
        answer.append(queue.popleft())
        count = 1
    else:
        num = queue.popleft()
        queue.append(num)
        count+=1
print("<",end="")
for i in range(len(answer)):
    print(answer[i], end = "")
    if i != len(answer) -1:
        print(", ",end="")
print(">")
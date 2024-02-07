import sys
from collections import deque
input = sys.stdin.readline
N, K = map(int, input().split())
belt = deque(map(int, input().split()))
robot = deque([0] * N)
answer = 0
cnt = 0
while(cnt < K):
    belt.rotate(1)
    robot.rotate(1)
    if robot[-1] == 1:
        robot[-1] = 0
    for i in range(N, 1, -1):
        if robot[i-1] == 1 and robot[i] == 0 and belt[i] > 0:
            robot[i-1] = 0
            robot[i] = 1
            belt[i] -= 1
            if belt[i] == 0:
                cnt += 1
    if robot[-1] == 1:
        robot[-1] = 0
    if belt[0] > 0:
        robot[0] = 1
        belt[0] -= 1
        if belt[0] == 0:
            cnt += 1
    answer += 1
print(answer)
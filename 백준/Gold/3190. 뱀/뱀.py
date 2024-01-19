import sys
from collections import deque
import heapq
input = sys.stdin.readline
N = int(input())
K = int(input())
queue = []
pos = []
total_time = 0
graph = [[] for _ in range(N+2)]
dx = [0,1,0,-1]
dy = [1,0,-1,0]
for i in range(N+2):
    for j in range(N+2):
        if i == 0 or j == 0 or i == N+1 or j == N+1:
            graph[i].append(1)
        else :
            graph[i].append(0)

for _ in range(K):
    r, c = map(int, input().split())
    graph[r][c] = -1

L = int(input())
for _ in range(L):
    x, c = map(str, input().split())
    x = int(x)
    heapq.heappush(queue, ([x,c]))
# print(graph)
def solution(x, y):
    # print(queue)
    global total_time
    snake = deque()
    snake.append((x,y))
    index = 0
    while True:
        if queue:
            time, direction = heapq.heappop(queue)
        if time == total_time: # 현재 지난 시간과 전환 시간이 같다면 방향 전환
            if direction == 'L':
                index -= 1
            else:
                index += 1
            index = (index + 4) % 4
            x += dx[index]
            y += dy[index]
        else:
            heapq.heappush(queue,([time,direction]))
            x += dx[index]
            y += dy[index]
        total_time += 1
        # print(x,y, total_time)
        # print(snake)
        if graph[x][y] == 1:
            break
        elif graph[x][y] == -1:
            snake.append([x,y])
            graph[x][y] = 0
        else:
            if [x, y] in snake:
                break
            else:
                snake.popleft()
                snake.append([x,y])
solution(1,1)
print(total_time)
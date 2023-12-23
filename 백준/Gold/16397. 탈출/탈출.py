import sys, math
from collections import deque

N, T, G = map(int, sys.stdin.readline().split())
visited = [False] * 100000
queue = deque()
MAX = 100000

def calA(x):
    if 0 < x+1 < MAX:
        return x + 1
    else: return -1
def calB(x):
    if 0 < x*2 < MAX:
        return (x*2) - (10**(int(math.log10(x*2))))
    else:
        return -1

def bfs(num, count):
    queue.append([num, count])
    while queue:
        num, count = queue.popleft()
        if count > T:
            print("ANG")
            exit()
        if num == G:
            print(count)
            exit()
        else:
            count += 1
            nextNum = calA(num)
            if nextNum >= 0 and not visited[nextNum]:
                queue.append([nextNum, count])
                visited[nextNum] = True
            
            nextNum = calB(num)
            if nextNum >= 0 and not visited[nextNum]:
                queue.append([nextNum, count])
                visited[nextNum] = True
    print("ANG")

bfs(N, 0)
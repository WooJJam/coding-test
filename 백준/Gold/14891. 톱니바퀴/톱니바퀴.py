import sys
from collections import deque
input = sys.stdin.readline
gear = []
for _ in range(4):
    q = list(map(int, input().rstrip()))
    gear.append(deque(q))
moveCount = int(input())
move = []

for _ in range(moveCount):
    num, dir = map(int, input().split())
    move.append([num, dir])

def right(num, dir):
    if num > 3:
        return
    if gear[num][6] != gear[num-1][2]:
        right(num+1, -dir)
        gear[num].rotate(dir)

def left(num, dir):
    if num < 0:
        return
    if gear[num][2] != gear[num+1][6]:
        left(num-1, -dir)
        gear[num].rotate(dir)

for i in range(moveCount):
    num , dir = move[i]
    num -= 1
    if num == 3:
        left(num-1, -dir)
    elif num == 2 or num == 1:
        right(num+1, -dir)
        left(num-1, -dir)
    elif num == 0:
        right(num+1, -dir)
    gear[num].rotate(dir)
answer = 0

if gear[0][0] == 1:
    answer += 1
if gear[1][0] == 1:
    answer += 2
if gear[2][0] == 1:
    answer += 4
if gear[3][0] == 1:
    answer += 8

print(answer)

# 11111110           
# 00000000
# 11111111
# 11111111
# 1
# 2 1
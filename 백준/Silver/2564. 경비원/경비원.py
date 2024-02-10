import sys
input = sys.stdin.readline
N, M = map(int, input().split())
shop = int(input())
coordinate = []

def clockwise(start, end):
    startX, startY = start
    endX, endY = end
    if startX == 1: # 북쪽 방향에서 출발
        if endX == 1: # 도착지가 북쪽
            if endY > startY:
                return endY - startY
            else:
                return int(10e9)
        if endX == 2: # 도착지가 남쪽
            return N - startY + M + N - endY
        if endX == 3: # 도착지가 서쪽
            return int(10e9)
        else: # 도착지가 동쪽
            return N - startY + endY
    
    if startX == 2: # 남쪽 방향에서 출발
        if endX == 1: # 도착지가 북쪽
            return startY + M + endY
        if endX == 2: # 도착지가 남쪽
            if startY < endY:
                return int(10e9)
            else:
                return startY - endY
        if endX == 3: # 도착지가 서쪽
            return startY + M - endY
        else: # 도착지가 동쪽
            return int(10e9)
        
    elif startX == 3: # 서쪽 방향에서 출발
        if endX == 1: # 도착지가 북쪽
            return startY + endY
        if endX == 2: # 도착지가 남쪽
            return int(10e9)
        if endX == 3: # 도착지가 서쪽
            if startY < endY:
                return int(10e9)
            else:
                return startY - endY
        else: # 도착지가 동쪽
            return startY + N + endY
    
    else: # 동쪽 방향에서 출발
        if endX == 1: # 도착지가 북쪽
            return int(10e9)
        if endX == 2: # 도착지가 남쪽
            return M - startY + N - endY
        if endX == 3: # 도착지가 서쪽
            return M - startY + N + N - endY
        else: # 도착지가 동쪽
            if startY > endY:
                return int(10e9)
            else:
                return endY - startY

def counter_clockwise(start, end):
    startX, startY = start
    endX, endY = end
    if startX == 1: # 북쪽 방향에서 출발
        if endX == 1: # 도착지가 북쪽
            if startY < endY:
                return int(10e9)
            else:
                return startY - endY
        if endX == 2: # 도착지가 남쪽
            return startY + M + endY
        if endX == 3: # 도착지가 서쪽
            return startY + endY
        else: # 도착지가 동쪽
            return int(10e9)    
            
    elif startX == 2: # 남쪽 방향에서 출발
        if endX == 1: # 도착지가 북쪽
            return N - startY + M + N - endY
        if endX == 2: # 도착지가 남쪽
            if endY < startY:
                return int(10e9)
            else:
                return endY - startY
        if endX == 3: # 도착지가 서쪽
            return int(10e9)
        else: # 도착지가 동쪽
            return N - startY + M - endY
        
    elif startX == 3: # 서쪽 방향에서 출발
        if endX == 1: # 도착지가 북쪽
            return int(10e9)
        if endX == 2: # 도착지가 남쪽
            return M - startY + endY
        if endX == 3: # 도착지가 서쪽
            if startY > endY:
                return int(10e9)
            else:
                return endY - startY
        else: # 도착지가 동쪽
            return startY + N + endY
        
    else: # 동쪽 방향에서출발
        if endX == 1: # 도착지가 북쪽
            return startY + N - endY
        if endX == 2: # 도착지가 남쪽
            return int(10e9)
        if endX == 3: # 도착지가 서쪽
            return startY + N + endY
        else: # 도착지가 동쪽
            if startY < endY:
                return int(10e9)
            else: 
                return startY - endY

for _ in range(shop):
    r, c = map(int, input().split())
    coordinate.append([r,c])
x, y = map(int, input().split())
start = [x,y]

answer = 0
for i in range(shop):
    clockDist = clockwise(start, coordinate[i])
    counterClockDist = counter_clockwise(start, coordinate[i])
    answer += min(clockDist, counterClockDist)
print(answer)
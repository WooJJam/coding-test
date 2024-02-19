from collections import deque
def solution(land):
    answer = 0
    visited = [[0 for _ in range(len(land[0]))] for _ in range(len(land))]
    areaNum = 1
    val = {}
    for i in range(len(land)):
        for j in range(len(land[0])):
            if land[i][j] == 1 and not visited[i][j]:
                val[areaNum] = bfs(visited, land, i, j, areaNum)
                areaNum += 1
    answer = 0
    for y in range(len(land[0])):
        oil = set()
        result = 0

        for x in range(len(land)):
            if land[x][y] == 1:
                oil.add(visited[x][y])
        for i in oil:
            result += val[i]
            answer = max(answer, result)
        
    return answer

def bfs(visited, land, x, y, areaNum):
    count = 0
    queue = deque()
    queue.append([x,y])
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    visited[x][y] = areaNum
    
    while queue:
        count += 1
        x, y = queue.popleft()
        for i in range(4):
            nextX = dx[i] + x
            nextY = dy[i] + y

            if 0 <= nextX < len(land) and 0 <= nextY < len(land[0]) and not visited[nextX][nextY] and land[nextX][nextY] == 1:
                visited[nextX][nextY] = areaNum
                queue.append([nextX, nextY])

    return count
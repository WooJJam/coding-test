from collections import deque

dx = [0, 1, 0 ,-1]
dy = [-1, 0, 1, 0]

def bfs():
    queue = deque()
    queue.append((1,1))
    maze[1][1] = 1
    while queue:

        x, y = queue.popleft()

        if maze[x][y] == 3:
            return 1
        else:
            maze[x][y] = 1

            for i in range(4):
                nextX = dx[i] + x
                nextY = dy[i] + y

                if 0 <= nextX < 16 and 0 <= nextY < 16 and maze[nextX][nextY] != 1:
                    queue.append((nextX, nextY))
    
    return 0

for test_case in range(1, 11):
    _ = input()
    maze = []
    
    for _ in range(16):
        maze.append(list(map(int, input().rstrip())))

    answer = bfs()
    print(f"#{test_case} {answer}")
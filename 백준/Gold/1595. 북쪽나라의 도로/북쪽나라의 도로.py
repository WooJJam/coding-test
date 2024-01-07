import sys
input = sys.stdin.readline

graph = [[] for _ in range(10001)] 
edge = 0
stack = []
point = 0
index = 0
visited = [False] * 10001
w = 0

while True:
    try :
        a, b, c = map(int, input().split())
        graph[a].append((b,c))
        graph[b].append((a,c))
        edge += 1
    except:
        break

def dfs(x, w):
    visited[x] = True
    global point, index
    stack.append((x, w))
    while stack:
        x, w = stack.pop()
        for i in graph[x]:
            if point < w:
                point = w
                index = x
            if not visited[i[0]]:
                visited[i[0]] = True
                stack.append((i[0], w+i[1]))

dfs(1 , w)
visited = [False] * 10001
dfs(index, w)
print(point)
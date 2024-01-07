import sys
input = sys.stdin.readline

graph = [[] for _ in range(10001)] 
edge = 0
stack = []
point = 0
visited = []
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
    global point
    stack.append((x, w))
    while stack:
        x, w = stack.pop()
        for i in graph[x]:
            point = max(point, w)
            if not visited[i[0]]:
                visited[i[0]] = True
                stack.append((i[0], w+i[1]))

for i in range(1, edge):
    visited = [False] * 10001
    w = 0
    dfs(i , w)

print(point)
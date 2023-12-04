import sys

n = int(sys.stdin.readline())
want = list(map(int, sys.stdin.readline().split()))
k = int(sys.stdin.readline())

input = []
node = [[]for _ in range(n+1)]
visited = [False] * (n+1)
for i in range(k):
    input.append(list(map(int, sys.stdin.readline().split())))

for i in input :
    node[i[0]].append(i[1])
    node[i[1]].append(i[0])
count = 0
def dfs(start):
    global count
    visited[start] = True
    for i in node[start]:
        if not visited[i]:
            count += 1
            if i == want[1]:
                print(count)
                exit(0)
            else: 
                dfs(i)
    count -= 1
            
dfs(want[0])
print(-1)
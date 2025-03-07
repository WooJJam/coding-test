import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

N, M = map(int, input().split())
array = list(set(map(int, input().split())))
array.sort()

answer = []

def dfs(depth):
    if depth == M:
        print(*answer)
        return
    else:
        for i in range(len(array)):
            if depth == 0 or answer[-1] <= array[i]:
                answer.append(array[i])
                dfs(depth+1)
                answer.pop()

dfs(0)
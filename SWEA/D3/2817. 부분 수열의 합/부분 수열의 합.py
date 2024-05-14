T = int(input())

def dfs(_sum, depth):
    global answer 

    if _sum == K:
        answer += 1
        return
    
    if depth == N:
        return
    
    dfs(_sum + number[depth], depth+1)
    dfs(_sum, depth+1)

for test_case in range(1, T+1):
    N, K = map(int ,input().split())
    number = list(map(int, input().split()))
    answer = 0
    dfs(0, 0)
    print(f"#{test_case} {answer}")
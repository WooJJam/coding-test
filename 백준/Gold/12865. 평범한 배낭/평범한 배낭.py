import sys
N, K = map(int, sys.stdin.readline().split())
dp = [[0 for _ in range(K+1)] for _ in range(N+1)]

W = []
V = []
for i in range(N):
    w, v = map(int, sys.stdin.readline().split())
    W.append(w)
    V.append(v)
def dynamic():
    for i in range(1, N+1): # 입력받은 무게와 가치
        for j in range(1, K+1): # 1부터 가능한 무게까지 
            if j - W[i-1] < 0: # 최대 무게보다 크다면 이전에 담았던것 만큼
                dp[i][j] = dp[i-1][j]
            else: # 최대 무게 이하, 1개 담거나 2개 담는것 중 더 큰 값
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-W[i-1]] + V[i-1])
dynamic()
print(dp[N][K]) 
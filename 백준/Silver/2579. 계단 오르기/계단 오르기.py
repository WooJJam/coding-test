import sys
input = sys.stdin.readline
N = int(input())
stair = [0] * (N+1)
for i in range(1,N+1):
    stair[i] = int(input())
if N == 1:
    print(stair[1])
    exit()
dp = [0] * (N+1)
dp[1] = stair[1]
dp[2] = stair[1]+stair[2]
def dynamic():
    for i in range(3, N+1):
        dp[i] = max(dp[i-2]+stair[i], dp[i-3] + stair[i] + stair[i-1])
    return dp[-1]
print(dynamic())
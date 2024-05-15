N = int(input())
number = list(map(int ,input().split()))
dp = [1] * N

def dynamic(x):
    for i in range(x, N):
        for j in range(i):
            if number[i] > number[j]:
                dp[i] = max(dp[i], dp[j]+1)

dynamic(1)
print(max(dp))
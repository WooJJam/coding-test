N = int(input())
T = []
P = []

def dfs(time, price):
    global answer
    answer = max(answer, price)

    if time >= N:
        return

    dfs(time+1, price)
    if time + T[time] <= N:
        dfs(time+T[time], price + P[time])

for _ in range(N):
    answer = 0
    t, p = map(int, input().split())
    T.append(t)
    P.append(p)

dfs(0,0)
print(answer)

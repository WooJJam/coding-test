# 다이나믹 프로그래밍
# DP를 사용하여 피보나치 수열 구현

# 탑 다운 방식
d = [0] * 100

def fibo_top_down(x):
    if x == 1 or x == 2:
        return 1
    if d[x] != 0:
        return d[x]
    d[x] = fibo_top_down(x-1) + fibo_top_down(x-2)
    return d[x]

print(fibo_top_down(99))

# 보텀 업 방식
def fibo_bottom_up():
    d = [0] * 100
    d[1] = 1
    d[2] = 1
    n = 99

    for i in range(3, n+1):
        d[i] = d[i-1] + d[i-2]

    print(d[n])

fibo_bottom_up()
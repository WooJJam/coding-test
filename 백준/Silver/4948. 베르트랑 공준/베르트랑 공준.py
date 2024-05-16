def solve():
    global answer
    for i in range(2, int((2*N) ** 0.5) + 1):
        if check[i]:
            continue
        else:
            for j in range(i+i, 2*N+1, i):
                # print(i,j)
                check[j] = True

while True:
    answer = 0
    N = int(input())
    if N == 0:
        break
    else:
        check = [False] * ((2 * N)+1)
        solve()
        print(check[N+1:].count(False))
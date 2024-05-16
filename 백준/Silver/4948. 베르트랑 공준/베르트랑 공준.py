def solve():
    global answer
    for i in range(N+1, 2*N+1):
        for j in range(2, int((2*N)**(1/2)+1)):
            if i % j == 0 :
                break
        else:
            answer += 1
while True:
    answer = 0
    N = int(input())
    if N == 0:
        break
    else:
        solve()
        print(answer)
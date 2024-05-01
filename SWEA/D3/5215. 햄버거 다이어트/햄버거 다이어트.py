T = int(input())

def solve(x, sum_calori, sum_point):
    global answer
    for i in range(x, len(taste)):
        p, c = taste[i]
        if sum_calori + c <= L:
            sum_point += p
            sum_calori += c
            answer = max(answer, sum_point)
            solve(i+1, sum_calori, sum_point)
            sum_point -= p
            sum_calori -= c

        

for test_case in range(1, T+1):
    answer = 0
    N, L = map(int,input().split())
    taste=[]
    for _ in range(N):
        point, calorie = map(int, input().split())
        taste.append((point, calorie))
    taste.sort(reverse=True)
    solve(0, 0, 0)
    print(f"#{test_case} {answer}")
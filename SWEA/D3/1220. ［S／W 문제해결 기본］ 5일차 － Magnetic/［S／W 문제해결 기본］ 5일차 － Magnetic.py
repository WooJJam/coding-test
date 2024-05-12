#  N극
# -----
#  S극

for test_case in range(1, 11):
    N = int(input())
    maps = []
    answer = 0
    for _ in range(N):
        maps.append(list(map(int, input().split())))
    
    for i in range(N):
        for j in range(N):
            # 1이면 N극 이므로 밑으로 떨어짐
            if maps[i][j] == 1:
                for k in range(i+1, N):
                    if maps[k][j] == 1:
                        break
                    
                    if maps[k][j] == 2:
                        answer += 1
                        break
    print(f"#{test_case} {answer}")
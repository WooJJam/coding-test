T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    triangle = [[0 for _ in range(N)] for _ in range(N)]
    triangle[0][0] = 1
    for i in range(N):
        for j in range(0, i+1):
            if j ==0 or i == j:
                triangle[i][j] = 1
            else:
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j]
    
    print(f"#{test_case}")
    for i in range(N):
        for j in range(0, i+1):
            print(triangle[i][j], end=" ")
        print()
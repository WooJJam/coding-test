for test_case in range(1,11):
    n = int(input())
    max_col, max_row = 0, 0
    arr = []
    for _ in range(100):
        arr.append(list(map(int, input().split())))
    
    # row 합
    for i in range(100):
        sum_col = 0
        sum_col = sum(arr[i])
        if max_col < sum_col:
            max_col = sum_col
    
    # col 합
    for i in range(100):
        sum_row = 0
        for j in range(100):
            sum_row += arr[j][i]
        if max_row < sum_row:
            max_row = sum_row

    # 대각선 합
    max_cross_right, max_cross_left = 0, 0
    for i in range(100):
        max_cross_right += arr[i][i]
    for i in range(100):
        max_cross_left += arr[i][99-i]
    print(f"#{test_case} {max(max_row, max_col, max_cross_right, max_cross_left)}")
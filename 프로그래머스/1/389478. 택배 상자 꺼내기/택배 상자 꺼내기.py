def solution(n, w, num):
    
    # h: 높이
    # w: 너비
    if (n % w != 0):
        h = n // w + 1
    else:
        h = n // w
    
    stock = [[0 for _ in range(w)] for _ in range(h+1)]

    for i in range(h):
        for j in range(w):
            stock[i+1][j] = (w * i + j + 1)

    answer = 0
    set_box(h, stock)
    answer = check_box(h, w, stock, num, n)
    return answer

def set_box(h, stock):
    
    for i in range(h+1):
        if i % 2 == 0:
            stock[i].reverse()

def check_box(h, w, stock, num, n):
    
    for i in range(h, 0, -1):
        for j in range(w):
            if stock[i][j] == num:
                # print(h, j)
                if stock[h][j] > n:
                    return h-i
                else:
                    print(i, j)
                    return h+1-i
    
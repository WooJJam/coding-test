T = int(input())

for test_case in range(1, T + 1):

    N = int(input())
    
    price = list(map(int, input().split()))
    price.reverse()
    MAX = price[0]
    answer = 0
    for i in range(1, len(price)):
        if MAX <= price[i]:
            MAX = price[i]
            continue
        else: 
            answer += MAX - price[i]
    print(f"#{test_case} {answer}")
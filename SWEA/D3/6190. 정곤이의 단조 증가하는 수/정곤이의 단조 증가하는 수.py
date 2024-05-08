T = int(input())

def check(value):

    value = str(value)
    for i in range(len(value)-1):
        if value[i] > value[i+1]:
            return False
    return True
            

for test_case in range(1, T+1):
    N = int(input())
    number = list(map(int, input().split()))
    number.sort(reverse=True)
    
    answer = -1

    for i in range(N-1):
        for j in range(i+1, N):
            value = number[i] * number[j]
            if answer > value:
                break
            
            if check(value):
                answer = value

    print(f"#{test_case} {answer}")
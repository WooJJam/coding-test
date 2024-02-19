def solution(n):
    result = condition2(n)
    for i in range(n+1, 1_000_001):
        num = i
        if result == condition2(num):
            return num
            
def condition2(num):
    count = 1
    while num > 1 :
            if num % 2 != 0:
                count += 1
            num //= 2
    return count
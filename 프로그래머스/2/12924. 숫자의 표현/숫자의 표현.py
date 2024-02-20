def solution(n):
    result = 0
    count = 0
    for i in range(1, n):
        result = 0
        for j in range(i, n):
            result += j
            if result == n:
                count += 1
                break
            if result > n:
                break

    return count+1
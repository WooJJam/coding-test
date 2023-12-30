import sys, math
input = sys.stdin.readline
answerIndex = 1
while 1:
    a, b = map(int, input().split())
    answer = 0
    x = 0
    if a == 0:
        break
    while 1:
        x += 1
        triangle = x*(x+1) // 2
        if  a <= triangle:
            if b-1 <= triangle:
                break
            square = triangle+1
            if square == int(math.sqrt(square)) * int(math.sqrt(square)):
                answer+=1
    print(f"Case {answerIndex}: {answer}")
    answerIndex+=1
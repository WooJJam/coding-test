import sys

input = sys.stdin.readline

N, L = map(int, input().split())

def getNumerator(N, l): # 분자
    return 2 * N - (l *( l - 1))

def getDenominator(l): # 분모
    return 2 * l

def getAnswer(start, l):
    answer = []
    for i in range(l):
        answer.append(start + i)
    return answer


for i in range(1, 101):

    numerator = getNumerator(N, i)
    denominator = getDenominator(i)
    answer = []
    if 0 <= numerator and 0 < denominator and numerator % denominator == 0 and i >= L:
        answer = (getAnswer(numerator // denominator, i))
        break
    else:
        answer.append(-1)

print(*answer)

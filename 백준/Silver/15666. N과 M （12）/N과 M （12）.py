import sys
from itertools import product

input = sys.stdin.readline

N, M = map(int, input().split())
array = list(map(int, input().split()))
array.sort()
status = True

answer = []

for number in product(array, repeat = M):
    for j in range(M-1):
        for k in range(j, M):
            if number[j] > number[k]:
                status = False
                break

        if not status:
            status = True
            break
    else:
        if number not in answer:
            answer.append(number)

for number in answer:
    print(" ".join(map(str, number)))
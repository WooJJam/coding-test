import sys
from itertools import product

input = sys.stdin.readline

N, M = map(int, input().split())
array = list(map(int, input().split()))
array.sort()

answer = []

for number in product(array, repeat = M):
    for j in range(M-1):
        if number[j] > number[j+1]:
            break
    else:
        if number not in answer:
            answer.append(number)

for number in answer:
    print(" ".join(map(str, number)))
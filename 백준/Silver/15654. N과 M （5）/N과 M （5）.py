import sys
from itertools import permutations
input = sys.stdin.readline
N, M = map(int, input().split())
number = list(map(int, input().split()))
answer = list(permutations(number, M))
answer.sort()
for i in range(len(answer)):
    print(" ".join(map(str, answer[i])))
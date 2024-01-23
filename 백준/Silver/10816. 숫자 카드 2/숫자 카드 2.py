import sys, bisect
input = sys.stdin.readline
N = int(input())
card = list(map(int, input().split()))
card.sort()
M = int(input())
match = list(map(int, input().split()))
answer = []
for i in range(M):
    answer.append(bisect.bisect_right(card, match[i]) - bisect.bisect_left(card, match[i]))
print(*answer)
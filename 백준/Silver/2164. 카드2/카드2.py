import sys
from collections import deque
input = sys.stdin.readline
card = deque()
N = int(input())
for i in range(1, N+1):
    card.append(i)
def solve():
    while len(card) > 1:
        card.popleft()
        if len(card) > 1:
            card.append(card.popleft())
    return card.popleft()
print(solve())
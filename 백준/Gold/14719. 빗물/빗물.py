import sys
input = sys.stdin.readline
H, W = map(int, input().split())
rain = list(map(int, input().split()))
amount = 0
for i in range(1, W-1):
    left = max(rain[:i])
    right = max(rain[i+1:W])
    compare = min(left, right)
    if compare > rain[i]:
        amount += compare - rain[i]
print(amount)
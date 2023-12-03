import sys

N = int(sys.stdin.readline())
distances= list(map(int, sys.stdin.readline().split()))
prices = list(map(int, sys.stdin.readline().split()))

old_price = prices[0]
result = old_price * distances[0]

for i in range(1,N-1) :
    if old_price > prices[i]:
        old_price = prices[i]
    result += old_price * distances[i]
   
print(result)
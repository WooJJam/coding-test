N = int(input())
P = list(map(int, input().split()))

P.sort(reverse=False)
total_sum = 0
result = []

for i in P :
    total_sum += i
    result.append(total_sum)

print(sum(result))
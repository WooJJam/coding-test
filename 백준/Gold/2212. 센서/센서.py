N = int(input())
K = int(input())
sensor = list(map(int, input().split()))
sensor.sort()
result = []

for i in range(len(sensor)-1):
    result.append(abs(sensor[i] - sensor[i+1]))
result.sort(reverse=True)

print(sum(result[K-1:]))
N = int(input())
result = 0
count = 0
while(True):
    if result > N:
        print(count - 1)
        break
    count += 1
    result += count
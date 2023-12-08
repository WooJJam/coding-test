N = int(input())
end = 1
result = 0
count = 0
while(True):
    if result == N :
        print(count)
        break
    elif result > N:
        print(count - 1)
        break
    result += end
    end += 1
    count += 1
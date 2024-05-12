N = int(input())
if N < 100:
    print(N)
    exit()
answer = 99
# 100 이상일때만 확인
for i in range(100, N+1):
    _i = str(i)
    count = 0
    result = int(_i[0]) - int(_i[1])
    for j in range(1, len(_i)-1):
        if result != int(_i[j]) - int(_i[j+1]):
            break
    else:
        answer += 1

print(answer)
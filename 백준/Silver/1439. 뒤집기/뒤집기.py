import sys
input = sys.stdin.readline

num = list(map(str, input().rstrip()))
zeroCount = 0
oneCount = 0
check = num[0]
if '0' and '1' in num:
    for i in range(len(num)):
        if num[i] == '0':
            if check == '0':
                continue
            else :
                oneCount += 1
                check = '0'
        elif num[i] == '1':
            if check == '1':
                continue
            else:
                zeroCount += 1
                check = '1'

    if num[-1] == '1':
        oneCount += 1
    else:
        zeroCount += 1

    print(min(zeroCount, oneCount))
else:
    print(0)
    exit(0)
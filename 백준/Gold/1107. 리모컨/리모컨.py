import sys

num = int(sys.stdin.readline())
N = [int(digit) for digit in str(num)]
broken = int(sys.stdin.readline())

if broken == 0:
    print(min(len(N), max(100, num) - min(100,num)))
    exit()

button = list(map(int, sys.stdin.readline().split()))

result = 0
MIN = 500000
for i in range(500001*2):
    flag = True
    temp = str(i)
    for j in range(len(temp)):
        if int(temp[j]) in button :
            flag = False
            break
    if flag:
        result = len(temp) + (max(i, num) - min(i, num))
        flag = True
        if MIN > result:
            MIN = result
    
print(min(max(100,num) - min(100,num), MIN))
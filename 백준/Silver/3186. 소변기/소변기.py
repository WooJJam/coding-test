import sys
input = sys.stdin.readline

K, L, N = map(int, input().split())
data = list(input().rstrip())
time = 0
notUsing = 0
usingTime = 0
using = False
answer = []
for i in data:
    time += 1
    if not using:
        if i == '1':
            usingTime += 1
            if usingTime >= K:
                using = True
                usingTime = 0
        else: 
            usingTime = 0
    else :
        if i == '0':
            notUsing += 1
            if notUsing >= L:
                answer.append(time)
                notUsing = 0
                using = False
        elif i == '1':
            using = True
            notUsing = 0
if using :
    answer.append(time+L)
if len(answer) == 0:
    print("NIKAD")
else: 
    for i in answer:
        print(i)
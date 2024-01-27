import sys
input = sys.stdin.readline
hour, min = map(int, input().split(":"))
answer = 1
answer += (hour//10 + hour%10)
if min < 30:
    answer += (min//10)
elif  min >= 30:
    answer += ((min-30)//10)
print(answer)
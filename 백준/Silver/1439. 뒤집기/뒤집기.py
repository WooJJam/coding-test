import sys
input = sys.stdin.readline
num = list(map(str, input().rstrip()))
answer = 0
for i in range(len(num) - 1):
    if num[i] != num[i+1]:
        answer += 1
print((answer+1)//2)
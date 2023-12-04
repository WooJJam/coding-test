import sys

N = int(sys.stdin.readline())
ball = sys.stdin.readline().strip()
answer=[]

remain = ball.rstrip('R')
answer.append(remain.count('R'))
reamin = ball.rstrip('B')
answer.append(remain.count('B'))
remain = ball.lstrip('R')
answer.append(remain.count('R'))
remain = ball.lstrip('B')
answer.append(remain.count('B'))
print(min(answer))
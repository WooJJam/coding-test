import sys
x,y,w,s = map(int, sys.stdin.readline().split())
answer = 0
if (x == 1 and y == 0) or (x == 0 and y == 1) :
    answer += w
else :
    if w * 2 < s:
        answer = w * x + w * y
    elif s < w:
        if (x + y) % 2 == 0:
            answer = max(x,y) * s
        else :
            answer = (max(x,y)-1) * s + w
    else:
        answer = min(x,y) * s + (max(x,y) - min(x,y)) * w
print(answer)
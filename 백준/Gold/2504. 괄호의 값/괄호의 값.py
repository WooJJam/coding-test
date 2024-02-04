import sys
input = sys.stdin.readline

stack = []
brcket = list(map(str, input().rstrip()))

problem = 1
answer = 0
flag = True
for i in range(len(brcket)):
    if brcket[i] == "(":
        flag = True
        stack.append(brcket[i])
        problem *= 2
    elif brcket[i] == "[":
        flag = True
        stack.append(brcket[i])
        problem *= 3
    elif brcket[i] == ")":
        if len(stack) == 0 or stack[-1] != "(":
            print(0)
            exit()
        else:
            stack.pop()
            if not flag:
                problem //= 2
                continue
            else:
                answer += problem
                flag = False
                problem //= 2
    elif brcket[i] == "]":
        if len(stack) == 0 or stack[-1] != "[":
            print(0)
            exit()
        else:
            stack.pop()
            if not flag:
                problem //= 3
                continue
            else:
                answer += problem
                flag = False
                problem //= 3

if len(stack) != 0 or len(stack) != 0:
    print(0)
else:
    print(answer)
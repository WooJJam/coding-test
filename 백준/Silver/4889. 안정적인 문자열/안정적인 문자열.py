import sys
input = sys.stdin.readline
test = 1
while True:
    close = 0
    stack = []
    bracket = list(map(str, input().rstrip()))
    if bracket[0] == "-":
        break
    for i in range(len(bracket)):
        if bracket[i] == '{':
            stack.append('{')
        else:
            if len(stack) == 0:
                close += 1
                stack.append("{")
            else:
                stack.pop()
    print(f"{test}. {len(stack)//2 + close}")
    test+=1
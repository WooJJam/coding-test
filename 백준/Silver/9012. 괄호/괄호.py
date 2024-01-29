import sys
input = sys.stdin.readline
T = int(input())
answer = []
def VPS_check(ps, stack):
    for i in ps:
        if i == "(":
            stack.append(i)
        else:
            if len(stack) == 0:
                return "NO"
            else:
                stack.pop()
    if len(stack) == 0:
        return "YES"
    else:
        return "NO"
for _ in range(T):
    ps = list(map(str, input().rstrip()))
    stack = []
    answer.append(VPS_check(ps, stack))
for i in answer:
    print(i)
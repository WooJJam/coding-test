import sys
input = sys.stdin.readline
M = int(input())
S = 0
for i in range(M):
    op = input().split()
    if op[0] == 'add':
        S |= (1 << int(op[1]))
    elif op[0] == 'remove':
        S &= ~(1 << int(op[1]))
    elif op[0] == 'check':
        if S & (1 << int(op[1])):
            print(1)
        else :
            print(0)
    elif op[0] == 'toggle':
        S ^= (1 << int(op[1]))
    elif op[0] == 'empty':
        S = 0
    elif op[0] == 'all':
        S |= (1 << 21)-1
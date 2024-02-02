import sys
input = sys.stdin.readline
S = list(map(str, input().rstrip()))
T =  list(map(str, input().rstrip()))
while len(S) != len(T):
    if T[-1] == 'A':
        T.pop()
    else:
        T.pop()
        T.reverse()
print(1 if T == S else 0)
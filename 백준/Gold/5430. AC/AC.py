import sys
from collections import deque
input = sys.stdin.readline
T = int(input())
for _ in range(T):
    result = []
    p = input().rstrip()
    n = int(input())
    if n:
        x = list(map(int, input()[1:-2].split(",")))
    else:
        input()
        x = []
    q = deque(x)
    flag = False # R 이 나올때마다 뒤에서 뺌 True: 나온적 있다, False: 없다
    for i in range(len(p)):
        if p[i] == 'R':
            if not flag:
                flag = True
            else:
                flag = False
        else:
            if not q:
                print("error")
                break
            if not flag:
                q.popleft()
            else:
                q.pop()
    else:
        while q:
            if flag:
                result.append(q.pop())
            else:
                result.append(q.popleft())
        print("[{}]".format(','.join(map(str,result))))

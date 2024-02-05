import sys
input = sys.stdin.readline

def check_str(s, t):
    pos = 0
    for i in range(len(s)):
        check = False
        for j in range(pos, len(t)):
            if s[i] == t[j]:
                pos = j+1
                check = True
                break
        if not check:
            print("No")
            break
    if check:
        print("Yes")
        
while True:
    try:
        s,t = map(str, input().split())
        s = list(s)
        t= list(t)
        check_str(s,t)
    except:
        break
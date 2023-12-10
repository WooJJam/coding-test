import sys
N = int(sys.stdin.readline())
count = 0
if N % 5 == 0:
    print(N // 5)
else:
    while(N > 0):
        N -= 3
        count += 1
        if N % 5 == 0:
            print(count + N // 5)
            break
        elif N == 1 or N == 2:
            print(-1)
            break
        elif N == 0:
            print(count)
            break
    else:
        print(-1)
N = int(input())

if N % 3:
    print("-1")
else :
    number = ''.join(sorted(str(N), reverse=True))
    if number[-1] != '0':
        print("-1")
    else :
        print(number)
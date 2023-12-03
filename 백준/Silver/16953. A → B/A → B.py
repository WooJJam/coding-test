A, B = map(int, input().split())
count = 0
while(B > A):
    if B % 10 == 1:
        B //= 10
        count += 1
    elif B % 2 != 0:
        break
    else :
        B //= 2
        count += 1

if A == B:
    print(count + 1)
else :
    print(-1)
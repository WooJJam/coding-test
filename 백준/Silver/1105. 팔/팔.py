import sys
L,R = sys.stdin.readline().split()
count = 0
if len(L) != len(R):
    print(count)
else:
    for i,j in zip(L,R):
        if i != j:
            break
        else:
            if i == j == '8':
                count += 1
    print(count)
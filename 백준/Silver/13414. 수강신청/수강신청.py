import sys

K, L = map(int, sys.stdin.readline().split())
a = {}

for i in range(L):
    student = sys.stdin.readline().split()
    for j, value in enumerate(student):
        a[value] = i 

result = {key: value for key, value in sorted(a.items(), key=lambda item: item[1])}
count = 0
for i in result:
    if count == K:
        break
    else:
        print(i)
        count += 1
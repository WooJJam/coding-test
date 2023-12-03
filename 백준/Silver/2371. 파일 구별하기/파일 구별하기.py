import sys
N = int(sys.stdin.readline())

input =[]
for _ in range(N):
    input.append(list(map(int, sys.stdin.readline().split()[:-1])))

input.sort(reverse=False, key=lambda x: len(x))
max = len(input[-1])

for i in range(max):
    count = 0
    check = set()
    for j in range(N):
        if len(input[j]) > i:
            check.add(input[j][i])
        else:
            count +=1
    if len(check) + count == N:
            print(i+1)
            break
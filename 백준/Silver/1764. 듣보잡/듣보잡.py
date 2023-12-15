import sys
N, M = map(int, sys.stdin.readline().split())
not_listen = {}
count = 0
duplicate = []
for _ in range(N):
    not_listen[sys.stdin.readline().rstrip()] = -1
for _ in range(M):
    word = sys.stdin.readline().rstrip()
    if word in not_listen:
        duplicate.append(word)
        count += 1
print(count)
duplicate.sort()
for i in range(count):
    print(duplicate[i])
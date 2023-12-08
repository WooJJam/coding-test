import sys
N = int(sys.stdin.readline())
k = []
for _ in range(N):
    k.append(int(sys.stdin.readline()))

k.sort()
rope = []
max_number = k[-1]

for i in range(N):
    if k[i] >= (max_number // 2):
        rope.append(k[i])

answer = rope[0] * len(rope)
print(answer)
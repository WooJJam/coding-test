import sys
input = sys.stdin.readline
N = int(input())
word = []
for _ in range(N):
    w = input().rstrip()
    word.append(w)
word.sort()
answer = 1
for i in range(N-1):
    prefix = word[i]
    check = word[i+1]
    j = 0
    for _ in range(len(prefix)):
        if prefix[j] != check[j]:
            answer += 1
            break
        else:
            j += 1
print(answer)
import sys
input = sys.stdin.readline

cipher = list(map(str, input().rstrip()))
N = int(input())
words = []
for _ in range(N):
    words.append(input().rstrip())
count = 0
for _ in range(26):
    answer = ''
    for i in cipher:
        w = chr(ord(i) - count)
        if w < "a":
            w = chr(ord(w) + 26)
        answer += w
    for i in range(N):
        if words[i] in answer:
            print(answer)
            exit()
    count += 1
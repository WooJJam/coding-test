import sys
input = sys.stdin.readline
S = list(input().rstrip())
zero = S.count("0")
one = len(S) - zero
answer = ""
count = 0
for i in range(len(S)-1,-1,-1):
    if S[i] == "0" and count < (zero//2):
        S[i] = "-1"
        count += 1
    if count == zero:
        break
count = 0
for i in range(len(S)):
    if S[i] == "1" and count < (one//2):
        S[i] = "-1"
        count += 1
    if count == one:
        break

for i in range(len(S)):
    if S[i] == "-1":
        continue
    else:
        print(S[i], end="")
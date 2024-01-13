import sys
input = sys.stdin.readline
S = input().rstrip()
zero = S.count("0")
one = len(S) - zero
answer = ""
for _ in range(zero//2):
    answer += "0"
for _ in range(one//2):
    answer += "1"
print(answer)
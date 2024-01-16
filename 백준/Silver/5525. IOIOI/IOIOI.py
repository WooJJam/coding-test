import sys
sys.stdin.readline

N = int(input())
M = int(input())
S = list(map(str, input().rstrip()))
P = []
for i in range((N*2)+1):
    if not i % 2:
        P.append("I")
    else:
        P.append("O")
table = [0] * len(P)
def kmp_table():
    pattern_size = len(P)
    j = 0
    for i in range(1, pattern_size):
        while j > 0 and P[i] != P[j]:
            j = table[j-1]
        if P[i] == P[j]:
            j += 1
            table[i] = j
answer = 0
def kmp():
    kmp_table()
    pattern_size = len(P)
    global answer
    j = 0

    for i in range(M):
        while j>0 and S[i] != P[j]:
            j = table[j-1]
        if S[i] == P[j]:
            if j == pattern_size-1:
                # print(i - pattern_size + 1,j)
                j = table[j]
                answer += 1
            else:
                j += 1
kmp()
print(answer)
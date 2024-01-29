import sys
input = sys.stdin.readline
S, P = map(int, input().split())
dna = list(map(str, input().rstrip()))
A, C, G, T = map(int, input().split())
count = {'A':0, 'C':0, 'G':0, 'T':0}
start = 0
answer = 0
def check(count):
    global answer
    if count['A'] >= A and count['C'] >= C and count['G'] >= G and count['T'] >= T:
        answer += 1
for i in range(P):
    count[dna[i]] += 1
check(count)
for i in range(P, len(dna)):
    count[dna[start]] -= 1
    count[dna[i]] += 1
    start += 1
    check(count)
print(answer)
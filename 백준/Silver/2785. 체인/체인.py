import sys
N = int(sys.stdin.readline())
chain = list(map(int, sys.stdin.readline().split()))

chain.sort(reverse=False)
total_chain = sum(chain)
i = 0
end = -1
answer = chain[end]
cnt = 0

while(True):
    if total_chain == answer or end == i:
        break
    if chain[i] > 0:
        end -= 1
        chain[i] -= 1
        answer += chain[end] + 1
        cnt += 1
    else :
        i += 1

print(cnt)
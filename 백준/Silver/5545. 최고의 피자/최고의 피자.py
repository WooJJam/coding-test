import sys

N = int(sys.stdin.readline())
A,B = map(int,sys.stdin.readline().split())

dow = int(sys.stdin.readline())
toping = []

for _ in range(N):
    toping.append(int(sys.stdin.readline()))

toping.sort(reverse=True)
def cal(k):
    return A + (B*k)
arr = []
answer = dow // cal(0)
for i in range(len(toping)):
    arr.append(toping[i])
    result = cal(i+1)
    answer = max(answer,(sum(arr)+dow) // result)

print(answer)
import sys
N,M = map(int, sys.stdin.readline().split())

J = int(sys.stdin.readline())
start = 1
end = M
answer = 0
for i in range(J):
    apple = int(sys.stdin.readline())

    if end < apple:
        answer += (apple - end)
        end = apple
        start = end - M + 1
    elif start > apple:
        answer += (start - apple)
        start = apple
        end = apple + M - 1

print(answer)
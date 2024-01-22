import sys
input = sys.stdin.readline
N,B,W = map(int, input().split())
stone = list(map(str, input().rstrip()))
end = 0
b, w = 0, 0
check = True
answer = 0
# B보다 작거나 같게, W보다 같거나 많게
for start in range(N):
    while end < N:
        if stone[end] == "B":
            if b < B:
                b += 1
            else:
                break
        if stone[end] == "W":
            w += 1
        end += 1
    if stone[start] == "B":
        b -= 1
    else:
        w -= 1
    if b <= B and w >= W:
        answer = max(answer, end-start)

print(answer)
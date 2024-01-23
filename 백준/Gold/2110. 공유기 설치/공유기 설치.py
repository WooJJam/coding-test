import sys
input = sys.stdin.readline
N, C = map(int, input().split())
house = []
for _ in range(N):
    house.append(int(input()))
house.sort()
start = 1
end = house[N-1]
answer = 0
if C == 2:
    print(house[N-1] - house[0])
    exit()
while start < end:
    mid = (start+end)//2
    dist = house[0]
    count = 1
    for i in range(1, N):
        if house[i] - dist >= mid:
            count += 1
            dist = house[i]
    if count >= C:
        answer = max(answer, mid)
        start = mid + 1
    else:
        end = mid 
print(answer)
import sys
N = int(sys.stdin.readline())
color = list(sys.stdin.readline().strip())
bCount = 0
rCount = 0
for i in range(N):
    if i < (N-1) and color[i] == color[i+1] : continue
    
    if color[i] == 'B': bCount +=1
    else : rCount+=1
print(max(bCount, rCount) if bCount != rCount else bCount + 1)
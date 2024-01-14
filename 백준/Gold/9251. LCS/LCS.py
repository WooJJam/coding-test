import sys
input = sys.stdin.readline

a = list(map(str, input().rstrip()))
b = list(map(str, input().rstrip()))
LCS = [[0 for _ in range(1001)] for _ in range(1001)]

def dynamic(x, y):
    for i in range(1,x+1):
        for j in range(1,y+1):
            if i == 0 or j == 0:
                LCS[i][j] = 0
            elif a[i-1] == b[j-1]:
                LCS[i][j] = LCS[i-1][j-1] + 1
            else:
                LCS[i][j] = max(LCS[i-1][j], LCS[i][j-1])

dynamic(len(a), len(b))
print(LCS[len(a)][len(b)])
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
pack = []
each = []
for _ in range(M):
    packPrice, eachPrice = map(int, input().split())
    pack.append(packPrice)
    each.append(eachPrice)

pack.sort()
each.sort()

# 갯수가 6개 이하일경우
if N <= 6:
    # 패키지 1개만 구입 or 낱개로만 구입
    answer = min(pack[0], each[0]*N)
else:
    # 패키지로만 구입 or 낱개로만 구입 or 패키지 + 낱개로만 구입
    answer = min(((N//6)+1) * pack[0], N * each[0], ((N//6)*pack[0] + (N%6)*each[0]))

print(answer)
import sys
input = sys.stdin.readline
INF = int(10e9)
T = int(input())
width = [0] * 6
height = [0] * 6
for _ in range(T):
    answer = INF
    for i in range(3):
        A, B = map(int, input().split())
        width[i] = A
        height[i] = B
        width[i+3] = B
        height[i+3] = A

    for i in range(6):
        for j in range(6):
            for k in range(6):
                if i%3 == j%3 or j%3 == k%3 or i%3 == k%3:
                    continue

                # 직렬
                r = width[i] + width[j] + width[k]
                c = max(height[i], height[j], height[k])
                answer = min(answer, r*c)

                # 2개 1개?
                r = max(width[i] + width[j], width[k]) 
                c = max(height[i],height[j])+ height[k]
                answer = min(answer, r*c)
    print(answer)
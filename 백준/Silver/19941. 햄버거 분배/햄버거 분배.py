N, K = map(int, input().split())
problem = list(input())
sum = 0
for i in range(N):
    flag = False
    if problem[i] == 'P':
        for j in range(i-K, i+K+1):
            if j >= 0 and j < N:
                if problem[j] == 'H' :
                    problem[j] = 'X'
                    sum += 1
                    break
print(sum)   
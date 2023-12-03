N, K = map(int, input().split())
def greedy(k):
    if k == 1:
        return 1
    else:
        return k + greedy(k-1)
result = greedy(K)
if result <= N:
    if (result - N) % K:
        print(K)
    else :
        print(K-1)
else :
    print("-1")
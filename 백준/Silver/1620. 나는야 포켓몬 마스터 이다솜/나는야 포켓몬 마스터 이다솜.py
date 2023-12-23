import sys
N,M = map(int, sys.stdin.readline().split())
pokemon = dict()
index = dict()
answer = []
for i in range(1,N+1):
    pokemon[i] = sys.stdin.readline().rstrip()
    index[pokemon[i]] = i
for _ in range(M):
    n = sys.stdin.readline().rstrip()
    try:
        num = int(n)
        answer.append(pokemon[num])
    except:
        answer.append(index[n])
for i in range(len(answer)):
    print(answer[i])
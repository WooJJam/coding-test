import sys
input = sys.stdin.readline
crying = set()
T = int(input())
for _ in range(T):
    record = list(map(str, input().rstrip().split()))
    for _ in range(100):
        animal = list(map(str, input().rstrip().split()))
        if animal[0] == "what":
            break
        else:
            crying.add(animal[2])
    for k in record:
        if k not in crying:
            print(k, end=" ")
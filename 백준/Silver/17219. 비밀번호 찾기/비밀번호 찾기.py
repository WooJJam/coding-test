import sys
input = sys.stdin.readline
N,M = map(int, input().split())
site = {}
for _ in range(N):
    addr, password = sys.stdin.readline().split()
    site[addr] = password
for _ in range(M):
    addr = sys.stdin.readline().rstrip()
    print(site[addr])
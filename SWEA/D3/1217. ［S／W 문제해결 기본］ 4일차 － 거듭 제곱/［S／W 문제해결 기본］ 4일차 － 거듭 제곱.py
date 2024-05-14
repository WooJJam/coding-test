def solve(x, depth):
    if depth == M:
        return x
    else:
        return solve(x*N, depth + 1)
    
for test_case in range(1, 11):
    _ = int(input())
    N, M = map(int, input().split())
    print(f"#{test_case} {solve(N, 1)}")
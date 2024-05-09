T = int(input())
for test_case in range(1, T+1):
    P, Q, R, S, W = map(int, input().split())
    print(f"#{test_case} {min(W*P , Q if W <= R else Q + (W-R) * S)}")
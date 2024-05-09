T = int(input())
for test_case in range(1, T+1):
    s = list(map(str, input().rstrip()))
    i = 0

    for j in range(1, len(s)):
        if s[i:j] == s[i+j:i+2*j]:
            print(f"#{test_case} {j}")
            break
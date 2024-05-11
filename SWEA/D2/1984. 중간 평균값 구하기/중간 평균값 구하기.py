T = int(input())
for test_case in range(1, T+1):
    number = list(map(int, input().split()))
    MAX = max(number)
    MIN = min(number)
    SUM = sum(number) - MAX - MIN
    answer = round(SUM / (len(number)-2))
    print(f"#{test_case} {answer}")
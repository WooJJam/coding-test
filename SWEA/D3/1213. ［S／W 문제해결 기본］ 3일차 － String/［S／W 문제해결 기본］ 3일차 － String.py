for test_case in range(1,11):
    _ = input()
    search = list(map(str, input().rstrip()))
    s = list(map(str, input().rstrip()))
    answer = 0

    for i in range(len(s)):
        if s[i:i+len(search)] == search[:]:
            answer += 1
    print(f"#{test_case} {answer}")
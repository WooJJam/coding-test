for test_case in range(1, 11):
    N, number = map(str, input().split())
    N = int(N)
    number = list(number.rstrip())
    stack = [number[0]]
    for i in range(1, N):
        if len(stack) == 0:
            stack.append(number[i])
            continue
        num = stack.pop()
        if number[i] != num:
            stack.append(num)
            stack.append(number[i])
    print(f"#{test_case}", "".join(stack))
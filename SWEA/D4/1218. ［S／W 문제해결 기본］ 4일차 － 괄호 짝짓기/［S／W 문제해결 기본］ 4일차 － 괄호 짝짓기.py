for test_case in range(1, 11):
    N = int(input())
    s = list(map(str, input().rstrip()))
    
    answer = 1
    stack = []

    for i in range(N):
        if s[i] == '<' or s[i] == '(' or s[i] == '[' or s[i] == '{':
            stack.append(s[i])
        else:
            if len(stack) == 0:
                answer = 0
                break
            else:
                # 닫히는 문자이면 pop
                # > ] } )
                bracket = stack.pop()
                if bracket == '<' and s[i] == '>' or bracket == '(' and s[i] == ')' or bracket == '[' and s[i]  == ']' or bracket == '{' and s[i] == '}':
                    continue
                else:
                    answer = 0
                    break
    
    if len(stack) != 0:
        answer = 0
    
    print(f"#{test_case} {answer}")
                    
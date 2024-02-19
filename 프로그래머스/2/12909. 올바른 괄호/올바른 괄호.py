def solution(s):
    stack = []
    
    bracket = list(s)
    for i in bracket:
        if i == "(":
            stack.append("(")
        else:
            if len(stack) == 0 :
                return False
            else:
                stack.pop()
    if len(stack) != 0:
        return False
    
    return True
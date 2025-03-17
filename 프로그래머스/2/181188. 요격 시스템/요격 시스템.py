def solution(targets):
    
    targets.sort(key = lambda x : x[1])
    
    s, e = targets[0]

    answer = 0

    for i in range(1, len(targets)):
        if e <= targets[i][0]:
            answer += 1
            e = targets[i][1]
        
    return answer + 1
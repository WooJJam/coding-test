T = int(input())
for test_case in range(1, T+1):
    N, M, K = map(int, input().split())
    person = list(map(int,input().split()))
    person.sort()
    answer = "Possible"
    for i in range(len(person)):
        if person[i] < M:
            answer = "Impossible"
            break
        else:
            bread = (person[i]//M) * K
            if bread < i+1 :
                answer = "Impossible"
                break
    
    print(f"#{test_case} {answer}")
    

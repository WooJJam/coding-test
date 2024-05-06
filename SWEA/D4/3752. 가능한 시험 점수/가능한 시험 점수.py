T = int(input())

def solve():
    for grade in grades:
        for i in range(len(answer)):
            if not visited[grade+answer[i]]:
                visited[grade+answer[i]] = True
                answer.append(grade+answer[i])
    
for test_case in range(1, T+1):
    N = int(input())
    grades=(list(map(int, input().split())))
    answer = [0]
    visited = [False] * (sum(grades)+1)
    visited[0] = True
    solve()
    print(f"#{test_case} {len(answer)}")

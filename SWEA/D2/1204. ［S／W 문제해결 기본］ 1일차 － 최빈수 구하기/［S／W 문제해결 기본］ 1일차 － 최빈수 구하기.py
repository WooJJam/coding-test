T = int(input())

for test_case in range(1, T + 1):
    test_num = int(input())
    students = list(map(int, input().split()))
    grades = [0] * 101
    
    MAX = 0
    
    for i in students:
        grades[i] += 1
        if MAX <= grades[i]:
            MAX = grades[i]
            answer = i
            
    print(f"#{test_num} {answer}")
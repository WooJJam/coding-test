problem = input().split('-')

result = 0
answer = 0

for i in range(len(problem)):
    if i :
        for number in problem[i].split("+"):
            answer -= int(number)
    else:
       for number in problem[i].split("+"):
            answer += int(number)
print(answer)
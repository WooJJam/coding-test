line = int(input())
myList = []
grade = []

for i in range(line):
    grade.append(1)

for _ in range(line):
    myList.append(list(map(int, input().split())))

for i in range(len(myList)):
    for j in range(len(myList)):
        if(myList[i][0] < myList[j][0] and myList[i][1] < myList[j][1]):
            grade[i] +=1

result = " ".join(map(str, grade))
print(result)
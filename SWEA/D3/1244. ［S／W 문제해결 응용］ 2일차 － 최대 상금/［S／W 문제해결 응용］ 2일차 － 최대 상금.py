T = int(input())

def dfs(cnt):
    global answer

    if cnt == count:
        answer = max(answer, int("".join(map(str, number))))
        return
    

    for i in range(len(number)-1):
        for j in range(i+1, len(number)):
            number[i], number[j] = number[j], number[i]
            value = int("".join(map(str, number)))
            if (cnt, value) not in search:
                dfs(cnt+1)
                search.append((cnt, value))
            number[j], number[i] = number[i], number[j]

for testCase in range(1, T+1):
    num, count = map(str, input().split())
    count = int(count)
    number = list(map(int, num.rstrip()))
    search = []
    answer = 0
    dfs(0)
    print(f"#{testCase} {answer}")
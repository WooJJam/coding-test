T = int(input())

def getValue():
    value = 0
    # print("----------------")
    for i in range((len(farm) // 2)+1):
        for j in range(1, i+1):
            # print(i, len(farm) // 2 - j)
            # print(i, len(farm) // 2 + j)
            value += farm[i][len(farm) // 2 - j]
            value += farm[i][len(farm) // 2 + j]
        # print(i, len(farm) // 2)
        value += farm[i][len(farm)//2]

    # print("----------------------")
    t = 1
    for i in range((len(farm)//2), 0, -1):
        for j in range(1, i):
            # print((len(farm)) // 2 + t, (len(farm)//2 - j))
            # print((len(farm)) // 2 + t, (len(farm)//2 + j))
            value += farm[(len(farm)) // 2 + t][(len(farm)) // 2 - j]
            value += farm[(len(farm)) // 2 + t][(len(farm)) // 2 + j]
        # print("?", len(farm)//2+i, len(farm)//2)
        value += farm[len(farm)//2+i][len(farm)//2]
        t+=1
    return value

for test_case in range(1, T+1):
    N = int(input())
    farm = []
    if N == 1:
        value = int(input())
        print(f"#{test_case} {value}")
    else:
        for i in range(N):
            farm.append(list(map(int, input().rstrip())))
        value = getValue()
        print(f"#{test_case} {value}")
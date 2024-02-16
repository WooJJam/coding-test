number = [False] * 10_001

for i in range(1, 10_001):
    if i < 10:
        num = i + i
        if not number[num]:
            number[num] = True
    elif 10 <= i < 100:
        num = i + (i // 10) + (i % 10)
        if not number[num]:
            number[num] = True
    elif i < 1000:
        num = i + (i // 100) + (i % 100 // 10) + (i % 10)
        if not number[num]:
            number[num] = True
    elif i < 10000:
        num = i + (i // 1000) + (i % 1000 //100) + (i % 100 // 10) + (i % 10)
        if num <= 10000 and not number[num]:
            number[num] = True

for i in range(1, 10_001):
    if not number[i]:
        print(i)
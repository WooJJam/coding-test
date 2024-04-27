T = int(input())

for i in range(1, T + 1):
    num = str(i)
    if '3' in num or '6' in num or '9' in num:
        COUNT = num.count('3') + num.count('6') + num.count('9')
        print('-' * COUNT, end=' ')
    else:
        print(num, end=' ')
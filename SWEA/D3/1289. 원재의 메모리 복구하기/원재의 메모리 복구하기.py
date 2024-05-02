T = int(input())

def setMemoryBit():
    return ["0"] * len(number)

for test_case in range(1, T+1):
    number = list(map(str, input().rstrip()))
    bit = setMemoryBit()
    count = 0
    for i in range(len(number)):
        if number[i] != bit[i]:
            count += 1
            for j in range(i, len(bit)):
                bit[j] = number[i]
    print(f"#{test_case} {count}")
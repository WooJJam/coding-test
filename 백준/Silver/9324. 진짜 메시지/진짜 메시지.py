T = int(input())
for _ in range(T):
    m = input()
    msg= [0 for _ in range(26)]
    answer = 'OK'
    flag = False
    for i in range(len(m)):
        if flag:
            flag = False
            continue
        msg[ord(m[i])-65] += 1
        if msg[ord(m[i])-65] == 3:
            if i == len(m) - 1:
                answer = 'FAKE'
                break
            elif m[i] != m[i+1]:
                answer = 'FAKE'
                break
            flag = True
            msg[ord(m[i])-65] = 0
    print(answer)
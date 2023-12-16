N, r, c = map(int, input().split())
answer = 0
while(N != 0):
    N -= 1
    if r < 2**N and c < 2**N: # 1사분면
        continue
    elif r < 2**N and c >= 2**N: # 2사분면
        c -= 2**N
        answer += 2**N * 2**N
    elif r >= 2**N and c < 2**N: # 3사분면
        r -= 2**N
        answer += 2*(2**N) * (2**N)
    else:         
        r -= 2**N
        c -= 2**N
        answer += 3 * (2**N )* (2**N)
print(answer)
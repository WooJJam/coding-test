# 가로 체크
import copy
def width_check(x, y, words):
    if y + N <= 8:
        if N % 2 == 0: # 짝수일때
            wordA = list(words[x][y:y+N//2])
            wordB = list(words[x][y+N//2:y+N])
            wordB.reverse()
            if wordA == wordB:
                return True
        else: # 홀수 일때
            wordA = list(words[x][y:y+N//2])
            wordB = list(words[x][y+N//2+1:y+N])
            wordB.reverse()
            if wordA == wordB:
                return True
    return False

for test_case in range(1, 11):
    answer = 0
    N = int(input())
    words = []
    for i in range(8):
        words.append(list(map(str, input().rstrip())))
    col_words = copy.deepcopy(words)
    for i in range(8):
        for j in range(8):
            col_words[j][i] = words[i][j]
    for i in range(8):
        for j in range(8):
            if width_check(i,j, words):
                answer += 1
            if width_check(i,j, col_words):
                answer += 1
    print(f"#{test_case} {answer}")
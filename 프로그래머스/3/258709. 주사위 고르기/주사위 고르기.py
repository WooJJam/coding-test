from itertools import combinations, product
import bisect

def get_win_count(A, B):
    
    win = 0
    
    for a in A:
        win += bisect.bisect_left(B, a)
    
    return win

def solve(dice):
    
    MAX = 0
    answer = []

    choiceNum = len(dice) // 2
    

    for selectIndex in combinations(range(len(dice)), choiceNum):
        A = []
        B = []
        notSelectIndex = [i for i in range(len(dice)) if i not in selectIndex]

        for order in product(range(6), repeat=choiceNum):
            result = 0
            A.append(sum(dice[x][y] for x, y in zip(selectIndex, order)))
            B.append(sum(dice[x][y] for x, y in zip(notSelectIndex, order)))
        B.sort()
        
        win = get_win_count(A, B)
        
        if win > MAX:
            MAX = win
            answer = selectIndex
        
    return answer


def solution(dice):    
    answer = solve(dice)
    return [x+1 for x in answer]
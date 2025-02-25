def solution(friends, gifts):
    answer = 0
    
    to, amount, answer = getTable(friends, gifts)
    
    answer = solve(friends, to, amount, answer)
    
    return max(answer.values())
    

def getTable(friends, gifts):
    # 선물 지수
    amount = {friend: 0 for friend in friends}
    
    # 정답 배열
    answer = {friend: 0 for friend in friends}
    
    # A -> B 갯수
    to = {}
    for gift in gifts:
        A, B = gift.split()
        to[(A,B)] = 0
        to[(B,A)] = 0
    
    for gift in gifts:
        A, B = gift.split()
        to[A, B] += 1
        amount[A] += 1
        amount[B] -= 1
    # print(to)
    
    return to, amount, answer

def solve(friends, to, amount, answer):

    for i in range(len(friends)):
        for j in range(i +1, len(friends)):

            if (friends[i],friends[j]) in to:
                # print(friends[i],friends[j])
                # A -> B 보낸 횟수가 더 많은 경우
                if to[(friends[i],friends[j])] > to[(friends[j],friends[i])]:
                    answer[friends[i]] += 1
                elif to[(friends[i],friends[j])] < to[(friends[j],friends[i])]:
                    answer[friends[j]] += 1
                else:
                    if amount[friends[i]] > amount[friends[j]]:
                        answer[friends[i]] += 1
                    elif amount[friends[i]] < amount[friends[j]]:
                        answer[friends[j]] += 1
                # print(answer)
            else:
                # 둘다 교환하지 않은 경우
                if (i != j):
                    if amount[friends[i]] > amount[friends[j]]:
                        answer[friends[i]] += 1
                    elif amount[friends[i]] < amount[friends[j]]:
                        answer[friends[j]] += 1
    return answer


# ["muzi", "ryan", "frodo", "neo"], ["muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"]
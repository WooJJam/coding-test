from itertools import product

def solution(users, emoticons):
    rate = [10, 20, 30, 40]
    pairs = []
    temp = []
    for i in product(rate, repeat = len(emoticons)):
        pairs.append(i)
    for i in range(len(pairs)): # 이모티콘 비율의 조합 = 이모티콘의 수
        purchase = [0 for _ in range(len(users))]
        count = 0
        for k in range(len(users)):
            userRate, userPrice = users[k]
            for j in range(len(pairs[i])): # 이모티콘의 수랑 같음
                price = 0
                emoticonRate = pairs[i][j]
                emoticonPrice = emoticons[j]
                # print(emoticonRate, emoticonPrice, userRate, userPrice)
                if emoticonRate >= userRate:
                    price = (emoticonPrice // 100 * (100 - emoticonRate))
                    # price = round((1 - emoticonRate * 0.01) * emoticonPrice)
                
                if purchase[k] + price >= userPrice:
                    count += 1
                    purchase[k] = 0
                    break
                else:
                    purchase[k] += int(price)
            # print(count, purchase)
        temp.append((count, sum(purchase)))
    temp.sort(reverse=True)
    answer = temp[0]
    
    return answer
            
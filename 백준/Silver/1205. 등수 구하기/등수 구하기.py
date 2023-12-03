scoreCount, newScore, rankingSize = map(int, input().split())

if scoreCount:
    rankingList = list(map(int, input().split()))
else :
    rankingList = []

if scoreCount == rankingSize and rankingList[-1] >= newScore:
    print(-1)
else:
    rankingList.append(newScore)
    rankingList.sort(reverse=True)
    index = rankingList.index(newScore)
    print(index+1 if index<rankingSize else -1)
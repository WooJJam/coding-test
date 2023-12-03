game_time = 60*48
score = [0, 0, 0]
times = [0, 0, 0]

N = int(input())

for _ in range (N):
    team, time = map(str,input().split())
    min, sec = map(int, time.split(":"))

    time = min*60 + sec
    team = int(team)

    if team == 1:
        score[team] +=1
        if score[1] > score[2] and score[1] -1 == score[2] :
            times[1] += game_time - time
        elif score[1] == score[2]:
            times[2] = (times[2] - (game_time - time))

    elif team == 2:
        score[team] += 1
        if score[1] < score[2] and score[2] -1 == score[1]:
            times[2] += game_time - time
        elif score[1] == score[2]:
            times[1] = (times[1] - (game_time - time)) 

print("{:02d}:{:02d}".format(int(times[1] / 60), times[1] % 60))
print("{:02d}:{:02d}".format(int(times[2] / 60), times[2] % 60))

def solution(schedules, timelogs, startday):
    
    person = [1] * (len(schedules))
    
    for i in range(len(schedules)):
        if (schedules[i] + 10) % 100 > 59:
            schedules[i] = (((schedules[i] + 10) // 100) + 1) * 100 + (schedules[i] + 10) % 100 - 60
        else:
            schedules[i] += 10
    for i in range(len(timelogs)):
        checkday = startday
        for j in range(len(timelogs[i])):
            if checkday == 6 or checkday == 7:
                checkday = (checkday % 7) + 1
                continue
            else:
                if timelogs[i][j] > schedules[i]:
                    # print(i,j)
                    # print(timelogs[i][j], schedules[i])
                    person[i] = 0
                    break
            checkday = (checkday % 7) + 1
    return sum(person)

# schedules[0] = 730 + 10 = 740
# schedules[1] = 855 + 10 = 905
# schedules[2] = 700 + 10 = 710
# schedules[3] = 720 + 10 = 730

# timelogs[0][:] = 710, 2359, 1050, 700, 650, 631, 659 -> 최대 1000개
# 이벤트 시작 시간: startDay

# if startDay == 6 or startDay == 7: 주말이므로
#     스킵하자
# else:
#     startDay 를 1개씩 증가하는데 만약 startDay = (startDay) % 7 +1 을 저장하자.

# 그냥 완전 탐색 ㄱㄱ
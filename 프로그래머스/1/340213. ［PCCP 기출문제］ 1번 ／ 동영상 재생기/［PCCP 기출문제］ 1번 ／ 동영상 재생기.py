from collections import deque

def timeSplit(time):
    mm, ss = time.split(":")
    return int(mm) * 100 + int(ss)

def solution(video_len, pos, op_start, op_end, commands):
    total_video_time = timeSplit(video_len)
    pos_time = timeSplit(pos)
    op_start_time = timeSplit(op_start)
    op_end_time = timeSplit(op_end)
    
    q = deque(commands)
    
    answer_time = playVideo(q, total_video_time, pos_time, op_start_time, op_end_time)
    
    if answer_time // 100 < 10:
        answer = "0" + str(answer_time // 100)
    else:
        answer = str(answer_time // 100)
    
    answer += ":"
    
    if answer_time % 100 < 10:
        answer += "0" + str(answer_time % 100)
    else:
        answer += str(answer_time % 100)

    return answer

def playVideo(q, total_video_time, pos_time, op_start_time, op_end_time):
    
    while (q):
        command = q.popleft()
        # 현재 위치가 오프닝중이라면 오프닝 종료 시간으로 이동
        if op_start_time <= pos_time < op_end_time:
            pos_time = op_end_time
        if command == "prev": # 명령어가 10초전 이동이라면 10초 전으로 이동
            if pos_time - 10 < 0: # 10초전으로 이동했을때 영상 시작시간보다 작아진다면 0초로 초기화
                pos_time = 0
            elif (pos_time - 10) % 100 > 59: # 10초전이 00 보다 작아질경우 60초부터 감소
                pos_time = ((((pos_time - 10) // 100) * 100)) + (60 - (100 -((pos_time - 10) % 100)))
            else :
                pos_time -= 10
        elif command == "next":
            # if pos_time + 10 > total_video_time:
            #     pos_time = total_video_time
            #     print(pos_time)
            if (pos_time + 10) % 100 > 59:
                print(pos_time)
                print(((((pos_time) // 100) + 1) * 100))
                pos_time = ((((pos_time) // 100) + 1) * 100) + (((pos_time + 10) % 100) - 60)
                print(pos_time)
            else:
                pos_time += 10
            
            if pos_time > total_video_time:
                pos_time = total_video_time
                

    if op_start_time <= pos_time < op_end_time:
            pos_time = op_end_time
    return pos_time
# prev: 10초 전 -> 현재 10초 미만이라면 처음 위치
# next: 10초 후 -> 남은시간 10초 미만 마지막 위치
# op_start: 오프닝 건너뛰기 -> op_start <= 현재 위치 <= op_end 라면 op_end로 이동
# video_len: 비디오의 길이
# pos: 현재 재생위치

# commands를 Queue에 보관
# 명령어 = queue.pop()

# 1300 -> 10초 전 1259로 이동해야함

# input
#     -> ':'을 split하여 4자리 정수로 만들다.
#     -> ex) 13:00 이라면? 13, 00 -> 13*100 + 0 = 1300
#     -> ex2) 13:10 이라면? 13, 10 -> 13*100 + 10
import sys
input = sys.stdin.readline
start, end, streaming = input().split()
start = int(start[:2])*100 + int(start[3:])
end = int(end[:2])*100 + int(end[3:])
streaming = int(streaming[:2])*100 + int(streaming[3:])

check = set()
answer = 0
while True:
    try:
        time, name = input().split()
        student_time = int(time[:2])*100+int(time[3:])

        if student_time <= start:
            check.add(name)

        if end <= student_time <= streaming:
            if name in check:
                answer += 1
                check.remove(name)
    except:
        break
print(answer)

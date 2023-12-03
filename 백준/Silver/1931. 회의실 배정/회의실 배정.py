import sys

input_time = []

N = int(sys.stdin.readline())

for i in range(N):
    input_time.append(list(map(int, sys.stdin.readline().split())))

input_time.sort()

start = input_time[0][0]
end = input_time[0][1]
count = 1

for i in range(1, N) :
    new_start = input_time[i][0]
    new_end = input_time[i][1]

    if new_end < end :
        start = new_start
        end = new_end
    elif end <= new_start :
        count += 1
        end = new_end
    
print(count)
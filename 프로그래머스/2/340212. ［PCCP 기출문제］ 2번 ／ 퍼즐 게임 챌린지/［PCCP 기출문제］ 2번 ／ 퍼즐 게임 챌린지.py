def get_complete_time(diffs, times, level):
    
    time = 0
    for i in range(len(diffs)):
        
        if diffs[i] <= level:
            time += times[i]
        
        if diffs[i] > level:
            time += (diffs[i] - level) * (times[i] + times[i-1]) + times[i]
        
    return time

def search_level(diffs, times, limit, MIN):
    
    answer = 1
    start = 0
    end = 300_000
    
    while(start <= end):
        mid = (start + end) // 2
        time = get_complete_time(diffs, times, mid)
        
        if time <= limit and MIN >= mid and mid > 0:
            MIN = mid
            answer = mid
            end = mid - 1
        
        else:
            start = mid + 1
    
    return answer

def solution(diffs, times, limit):
    MIN = int(10e9)

    answer = search_level(diffs, times, limit, MIN)
    
    return answer
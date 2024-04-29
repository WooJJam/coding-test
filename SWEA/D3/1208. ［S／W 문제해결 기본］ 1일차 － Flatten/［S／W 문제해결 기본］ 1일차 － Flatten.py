
for test_case in range(1, 11):
    n = int(input())
    boxes = list(map(int, input().split()))
    count = 0

    while count < n:
        _max = max(boxes)
        _min = min(boxes)

        for i in range(100):
            if boxes[i] == _max:
                max_index = i
            
            if boxes[i] == _min:
                min_index = i
        
        boxes[max_index] -= 1
        boxes[min_index] += 1
        count += 1
    
    
    print(f" #{test_case} {max(boxes) - min(boxes)}")
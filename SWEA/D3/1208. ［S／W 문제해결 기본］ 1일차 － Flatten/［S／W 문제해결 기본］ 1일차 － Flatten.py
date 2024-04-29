
for test_case in range(1, 11):
    n = int(input())
    boxes = list(map(int, input().split()))
    count = 0

    while count < n:
        max_index, min_index = 0, 0
        _max, _min = float('-inf'), float('inf')

        # 최대값과 최소값의 인덱스 찾기
        for i, box in enumerate(boxes):
            if box > _max:
                _max = box
                max_index = i
            if box < _min:
                _min = box
                min_index = i
        
        boxes[max_index] -= 1
        boxes[min_index] += 1
        count += 1
    
    print(f"#{test_case} {max(boxes) - min(boxes)}")
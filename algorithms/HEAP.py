# defalut는 min heap -> 오름차순
import heapq

# 힙 정렬 (Heap Sort)
def heapsort(iterable):
    h = []
    result = []
    # 모든 원소를 차례대로 힙에 삽입 (오름차순)
    for value in iterable:
        heapq.heappush(h, value)
    
    # (내림차순)
    for value in iterable:
        heapq.heappush(h, -value)
    
    # 힙에 삽입된 모든 원소를 차레대로 꺼내어 담기
    for i in range(len(h)):
        # 오름차순, Min Heap
        result.append(heapq.heappop(h))

        # 내림차순, Max Heap
        result.append(heapq.heappop(h))

    return result

result = heapsort([1,3,5,7,9,2,4,6,8,0])
# print(result)
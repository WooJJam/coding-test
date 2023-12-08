# 이진탐색
# 정령되어 있는 리스트에서 탐색 범위를 좁혀감

def binary_search_recursion(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    if array[mid] == target:
        return mid
    elif array[mid] > target:
        return binary_search_recursion(array, target, start, mid - 1)
    else :
        return binary_search_recursion(array, target, mid + 1, end)

def binary_search_for_each(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return mid
        elif array[mid] > target:
            end = mid -1
        else:
            start = mid + 1
    return None

from bisect import bisect_left, bisect_right
# bisect_left(a, x): low bounder 와 같음, 정렬돤 순서를 유지하면서 배열 a에 x를 삽입할 가장 왼쪽 인덱스를 반환
# bisect_right(a, x): upper bounder 와 같음, 정렬된 순서를 유지하면서 배열 a에 x를 삽입할 가장 오른쪽 인덱스를 반환

def count_by_range(a, left_value, right_value):
    right_index = bisect_right(a, right_value)
    left_index = bisect_left(a, left_value)
    return right_index - left_index

# a = [1,2,4,4,8]
a = [1, 2, 3, 3, 3, 3, 4, 4, 8, 9]
x = 4
print(count_by_range(a, 4, 4))
print(count_by_range(a,-1, 3))
print(bisect_left(a,x))
print(bisect_right(a,x))

if __name__ == "__main__":
    n, target = list(map(int, input().split()))
    array = list(map(int, input().split()))
    result = binary_search_for_each(array, target, 0, n-1)
    if result == None:
        print("원소가 존재하지 않습니다.")
    else:
        print(result+1)
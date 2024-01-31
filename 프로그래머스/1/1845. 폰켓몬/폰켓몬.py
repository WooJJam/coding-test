def solution(nums):
    p = set(nums)
    if len(nums) // 2 < len(p):
        return len(nums) // 2
    else:
        return len(p)
        
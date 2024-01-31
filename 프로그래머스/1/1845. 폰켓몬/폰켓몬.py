def solution(nums):
    p = {}
    for i in range(len(nums)):
        p[nums[i]] = True
    if len(p) >= (len(nums)//2):
        return len(nums)//2
    else:
        return len(p)
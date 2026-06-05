class Solution:
    def search(self, nums: List[int], target: int) -> int:
        return self.helper(0, len(nums)-1, nums, target)

    def helper(self, low, high, nums, target):
        mid= low + (high - low)//2

        if(high > len(nums) or high < low):
            return -1
        if(nums[mid] == target):
            return mid
        elif(nums[mid] < target):
            return self.helper(mid+1, high, nums, target)
        else:
            return self.helper(low, mid-1, nums, target)


    
        
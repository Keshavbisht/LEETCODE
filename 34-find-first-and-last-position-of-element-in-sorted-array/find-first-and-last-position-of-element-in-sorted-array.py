class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        ans = []
        l = self.helperLower(0, len(nums)-1, nums, target)
        h = self.helperHigh(0, len(nums)-1, nums, target)
        ans = []
        ans.append(l)
        ans.append(h)
        return ans

    def helperLower(self, low, high, nums, target):
        mid = low + (high - low)//2

        if(low > high or high > len(nums)): return -1

        elif(nums[mid] == target):
            temp = self.helperLower(low, mid-1, nums, target)
            if(temp != -1): return temp
            return mid
        elif(nums[mid] < target):
            return self.helperLower(mid+1, high, nums, target)

        else:
            return self.helperLower(low, mid-1, nums, target)

    def helperHigh(self, low, high, nums, target):
        mid = low + (high - low)//2

        if(low > high or high > len(nums)): return -1

        elif(nums[mid] == target):
            temp = self.helperHigh(mid+1, high, nums, target)
            if(temp != -1): return temp
            return mid
        elif(nums[mid] < target):
            return self.helperHigh(mid+1, high, nums, target)

        else:
            return self.helperHigh(low, mid-1, nums, target)


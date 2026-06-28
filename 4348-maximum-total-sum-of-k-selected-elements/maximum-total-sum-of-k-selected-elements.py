class Solution:
    def maxSum(self, nums: list[int], k: int, mul: int) -> int:
        ans = 0
        nums.sort(reverse = True)
        for i in range(0, k, 1):
            if(mul > 0):
                ans = ans + (nums[i] * mul)
                mul = mul - 1
            else:
                ans = ans + nums[i]
        return ans
        
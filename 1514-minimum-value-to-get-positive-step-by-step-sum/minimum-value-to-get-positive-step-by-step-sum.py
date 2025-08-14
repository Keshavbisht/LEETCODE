class Solution:
    def minStartValue(self, nums: List[int]) -> int:
        m = s = 0


        for num in nums:
            s += num
            m = min(m, s)
        return 1 - m

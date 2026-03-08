class Solution:
    def smallestBalancedIndex(self, nums: list[int]) -> int:
        n = len(nums)
        prefix = []
        prefix.append(0)

        for i in range(1, n+1, 1):
            prefix.append( prefix[i-1] + nums[i-1])

        # print(prefix)
        prod = 1
        for i in range(n-1, -1, -1):
            # print(prod)
            if(i > 0 and prefix[i] == prod):
                print("hi")
                return i
            prod = prod * nums[i]
            if(prod > prefix[i]):
                return -1
            if(prefix[i-1] == prod):
                return i-1
        return -1
        
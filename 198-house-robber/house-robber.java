class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length +1];
        Arrays.fill(dp, -1);
        
        return Math.max(helper(nums.length-1, nums, dp), helper(nums.length-2, nums, dp));
    }
    public int helper(int ind, int[] nums, int[] dp){
        
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        if(ind == 0) return nums[0];
        // if(ind == 1) return nums[1];

        return dp[ind] = Math.max(helper(ind - 2, nums, dp), helper(ind-3, nums, dp)) + nums[ind];
    }
}
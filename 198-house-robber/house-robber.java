class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return Math.max(helper(n-1, nums, dp), helper(n-2, nums, dp));
    }
    public int helper(int n, int[] nums, int[] dp){
        if(n<=0) return nums[0];
        if(n==1) return nums[1];
        // if(n<0) return nums[0];
        if(dp[n] != -1) return dp[n];

        int a = helper(n-2, nums, dp) +nums[n];
        int b = helper(n-3, nums, dp) +nums[n];
        return dp[n] = Math.max(a,b);

    }
}
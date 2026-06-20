class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length+1];
        for(int[] itr: dp){
            Arrays.fill(itr, -1);
        }
        return helper(0, -1, 0, nums, dp);
    }

    public int helper(int ind, int prev,int ans, int[] nums, int[][] dp){
        if(ind >= nums.length){
            return 0;
        }
        if(dp[ind][prev+1] != -1) return dp[ind][prev+1];

        int notTake = helper(ind + 1, prev, ans, nums, dp);
        int take = 0;

        if(prev == -1 || nums[prev] < nums[ind]){
            take = 1 + helper(ind+1, ind, ans+1, nums, dp );
        }
        

        return dp[ind][prev+1] = Math.max(take, notTake);
    }
}
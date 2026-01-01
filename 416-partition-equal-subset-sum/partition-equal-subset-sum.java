class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum = sum + nums[i];
        }
        if(sum%2 != 0) return false;
        sum = sum/2;
        Boolean[][] dp = new Boolean[nums.length+1][sum+1];
        return helper(0, 0, sum, nums, dp);
    }
    public boolean helper(int ind, int total, int sum, int[] nums, Boolean[][] dp){
        if(total > sum) return false;
        if(ind == nums.length){
            if(total == sum) return true;
            return false;
        }
        if(dp[ind][total] != null) return dp[ind][total];
        return dp[ind][total] = helper(ind+1, total+nums[ind], sum, nums, dp) || helper(ind+1, total, sum, nums, dp);
    }
}
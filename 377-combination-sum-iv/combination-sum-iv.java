class Solution {
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        return helper(0, nums, target);
    }
    public int helper(int ind, int [] nums, int target){
        if(target == 0) return 1;
        if(dp[target] != -1) return dp[target];
        int a = 0;
        for(int i = 0; i< nums.length; i++){
            if(target - nums[i] >= 0){
                a += helper(ind, nums, target - nums[i]);
            }
        }
        

        return dp[target] = a;
    }
}
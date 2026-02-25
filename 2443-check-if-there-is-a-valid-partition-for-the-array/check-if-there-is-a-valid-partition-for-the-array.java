class Solution {
    public boolean validPartition(int[] nums) {
        Boolean dp[] = new Boolean[nums.length];
        Arrays.fill(dp, null);

        
        return helper(0, nums, dp);
    }
    public boolean helper(int ind, int[] nums, Boolean[] dp){
        if(ind > nums.length) return false;
        if(ind == nums.length) return true;

        if(dp[ind] != null) return dp[ind];
        boolean one = false;
        boolean two = false;
        boolean three = false;

        if(((nums.length - ind) >= 2) && (nums[ind] == nums[ind+1])){
            one = helper(ind+2, nums, dp);
        }
        if(((nums.length - ind) >= 3) && (nums[ind] == nums[ind+1] && nums[ind+1]  == nums[ind+2]) ){
            two = helper(ind+3, nums, dp);
        }
        if(((nums.length - ind) >= 3) && (nums[ind] == nums[ind+1]-1 && nums[ind+1] == nums[ind+2]-1)){
            three = helper(ind+3, nums, dp);
        }

        return dp[ind] = one || two || three;

    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int prefix = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i< nums.length; i++){
            if(prefix <=0){
                prefix = 0;
            }
            prefix = prefix + nums[i];
            
            maxi = Math.max(maxi, prefix);

        }
        return maxi;

    }
}
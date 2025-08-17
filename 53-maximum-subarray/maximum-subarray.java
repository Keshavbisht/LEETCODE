class Solution {
    public int maxSubArray(int[] nums) {

        int maxi = Integer.MIN_VALUE;
        int sum1 = 0;


        for(int i = 0; i< nums.length; i++){
            sum1 = sum1 + nums[i];
            maxi = Math.max(sum1, maxi);
            if(sum1 < 0){
                sum1 = 0;
            }
        }
        return maxi;
        
    }
}
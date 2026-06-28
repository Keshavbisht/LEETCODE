class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        int n = nums.length;

        long ans = 0;
        for(int i = n-1; i>n-k-1; i--){
            // System.out.println(i);
            if(mul >0){
                ans  = ans + (long)(nums[i]) * mul;
                mul--;
            }
            else{
                ans+=nums[i];
            }
        }
        return ans;
    }
}
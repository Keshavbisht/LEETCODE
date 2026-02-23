class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int prefix = 0;
        int pnt1 = 0;
        for(int pnt2 = 0; pnt2 < n; pnt2++){
            prefix += nums[pnt2];

            // if(prefix >= target){
            //     ans = Math.min(ans, pnt2 - pnt1 +1);
            // }
            while(prefix >= target){
                if(prefix >= target){
                    ans = Math.min(ans, pnt2 - pnt1 +1);
                }
                prefix -= nums[pnt1];
                pnt1++;
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
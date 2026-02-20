class Solution {
    public long countSubarrays(int[] nums, long k) {
        int pnt1 = 0;
        int pnt2 = -1;
        int n = nums.length;
        long ans = 0;
        long sumi = 0;

        while(pnt2 < n-1){
            pnt2++;
            sumi += nums[pnt2];

            while((sumi * (pnt2 - pnt1+1)) >= k){
                sumi = sumi - nums[pnt1];
                pnt1++;
            }
            ans += (pnt2 - pnt1 + 1);
        }
        return ans;

    }
}
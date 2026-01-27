class Solution {
    public long countSubarrays(int[] nums, int k) {
        long maxi = -1;

        for(int i = 0; i< nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
        }

        int pnt1 = 0; 
        int pnt2 = -1;
        long ans = 0;

        long count = 0;
        while(pnt2 < nums.length-1){
            pnt2++;
            if(nums[pnt2] == maxi){
                count++;
            }
            while(count >=k){
                if(nums[pnt1] == maxi){
                    count--;
                }
                pnt1++;
            }
            ans = ans + pnt1;

        }
        return ans;
    }
}
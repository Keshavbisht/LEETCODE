class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero = 0;
        int a = 0;
        int b = -1;
        int count = 0;
        int maxi = 0;
        int n = nums.length;
        
        while(b<n-1){
            b++;
            if(nums[b] == 0){
                zero++;
            }
            if(zero > k){
                while(zero > k){
                    if(nums[a] == 0){
                        zero--;
                    }
                    a++;
                }
            }

            maxi = Math.max(maxi, b - a +1);
        }
        return maxi;
    }
}
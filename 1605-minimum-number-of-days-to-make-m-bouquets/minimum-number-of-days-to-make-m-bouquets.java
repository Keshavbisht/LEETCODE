class Solution {
    public int minDays(int[] nums, int m, int k) {
        long low = 1;
        long high = -1;

        for(int i = 0; i< nums.length; i++){
            high = Math.max(high, nums[i]);
        }

        if(m*k > nums.length) return -1;
        long ans = -1;
        // System.out.println("hi");
        while(low <= high){
            long mid = low + (high-low)/2;

            boolean flag = helper(mid, m, k, nums);
            if(flag){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return (int) ans;
    }

    public boolean helper(long day, int m, int k, int[] nums){
        int ans = 0;
        int tempK = 0;

        for(int i = 0; i< nums.length; i++){

            if(nums[i] <= day){
                tempK++;
            }
            else{
                tempK = 0;
            }

            if(tempK == k){
                m--;
                tempK = 0;
            }
            // if(m <= 0) return true;
        }
        if(m <= 0) return true;
        return false;
    }
}
class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        // n * (k(k+1)/2) = ans;
        long low = 1;
        long high = 10000000000000000L;
        long ans = 0;

        while(low <= high){
            long mid = low + (high-low)/2;

            boolean flag = helper(mid, mountainHeight, workerTimes);
            if(flag){
                ans = mid;
                high = mid-1;
            }
            else{
                low= mid+1;
            }
        }
        return ans;
    }
    public boolean helper(long a, int n, int[] nums){
        long count = 0;

        for(int i = 0; i< nums.length; i++){
            double temp = (-1 + Math.sqrt(1 + (8.0 * a) / nums[i])) / 2.0;
            count += (long) temp;
            if(count >= n) return true;
        }
        return false;
    }
}
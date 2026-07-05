class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long high = -1;
        for(int i = 0; i< ranks.length; i++){
            high = Math.max(high, ranks[i]);
        }
        high = high * cars * cars;
        System.out.println(high);
        long ans = 0;

        while(low <= high){
            long mid = low + (high-low)/2;

            boolean flag = helper(mid, ranks, cars);
            if(flag){
                ans = mid;
                high = mid-1;

            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean helper(long a, int[] nums, int cars){
        long ans = 0;

        for(int i = 0; i< nums.length; i++){
            double temp = Math.sqrt(a/nums[i]);
            ans += (int) temp;
            if(ans >= cars) return true;
        }
        return false;
    }
}
class Solution {
    public int minSpeedOnTime(int[] nums, double hour) {
        long low = 1;
        long high = 0;

        for(int i = 0; i< nums.length; i++ ){
            high += nums[i];
        }
        high = high *100;
        long ans = -1;
        while(low <= high){
            long mid = low + (high - low)/2;

            boolean flag = helper(mid, hour, nums);
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
    public boolean helper(long a, double hour, int[] nums){
        double ans = 0;

        for(int i = 0; i< nums.length-1; i++){
            ans += Math.ceil((double)nums[i]/a);
            
        }
        ans += (double)nums[nums.length-1]/a;
        if(ans > hour) return false;
        return true;
    }
}
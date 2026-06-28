class Solution {
    public long minimumTime(int[] time, int h) {
        long low = 1;
        long high = -1;
        for(int i = 0; i< time.length; i++){
            high = Math.max(high, time[i]);
        }
        high = high * h;
        long ans = 0;

        while(low<= high){
            long mid = low + (high - low)/2;

            boolean flag = helper(mid, h, time);
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

    public boolean helper(long a, long h, int[] time){
        long ans = 0;
        for(int i = 0; i< time.length; i++){
            
            ans = ans + (a/time[i]);
        }
        if(ans >= h) return true;
        return false;

    }
}
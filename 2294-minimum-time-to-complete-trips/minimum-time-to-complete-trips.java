class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low = Long.MAX_VALUE;
        long high = -1;
        for(int itr: time){
            low = Math.min(low, itr);
            high = Math.max(high, itr);
        }
        high = high * totalTrips;
        long ans = high;

        while(low <= high){
            long mid = low + (high -low)/2;

            long temp = 0;
            for(int i = 0; i< time.length; i++){
                temp = temp + mid/time[i];
            }
            if(temp >=totalTrips ){
                ans = mid;
                high = mid -1;

            }
            else{
                low = mid+1;
            }
        }
        return ans;
        
    }
}
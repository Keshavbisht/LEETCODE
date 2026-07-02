class Solution {
    public int maximumCandies(int[] candies, long k) {
        long low = 1;
        long high = 0;
        for(int i=0; i< candies.length; i++){
            high = Math.max(high, candies[i]);
        }

        long ans = 0;
        while(low<=high){
            long mid= low + (high-low)/2;
            boolean flag = helper(mid, candies, k);

            if(flag){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return (int) ans;
    }
    public boolean helper(long a, int[] nums, long k){
        long ans = 0;

        for(int i = 0; i< nums.length; i++){
            long temp = nums[i]/a;
            if(temp > 0){
                ans+= temp;
            }
        }
        return (ans >= k) ? true: false;
    }
}
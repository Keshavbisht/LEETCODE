class Solution {
    public int minCapability(int[] nums, int k) {
        long low = Integer.MAX_VALUE;
        long high = -1;

        for(int i = 0; i< nums.length; i++){
            low = Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }
        long ans = 0;
        while(low <= high){
            long mid = low + (high - low)/2;
            System.out.println(mid);

            boolean flag = helper(mid, nums, k);
            if(flag){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return (int)ans;
    }
    public boolean helper(long a, int[] nums, int k){
        int count = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] <= a){
                count++;
                i = i+1;
            }
        }
        return (count >=k) ? true : false;
    }
}
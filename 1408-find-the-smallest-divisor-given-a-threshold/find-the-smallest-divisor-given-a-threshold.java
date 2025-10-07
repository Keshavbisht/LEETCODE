class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int low = 1;
        int high = 0;
        for(int i = 0; i< nums.length; i++){
            high = Math.max(high, nums[i]);
        }
        int ans = high;

        while(low <= high){
            int mid = low +(high - low)/2;
            boolean check = helper(nums, threshold, mid);
            if(check == true){
                ans = mid;
                high  = mid-1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;
        
    }
    public boolean helper(int[] nums, int threshold, int mid){
        int sum = 0;
        for(int i = 0; i< nums.length; i++){
            sum = sum + (int)Math.ceil((double)nums[i]/ mid);
        }
        return (sum<=threshold) ? true : false;
    }
}
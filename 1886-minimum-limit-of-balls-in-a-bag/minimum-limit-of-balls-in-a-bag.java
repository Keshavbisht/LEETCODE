class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i< nums.length; i++ ){
            high = Math.max(high, nums[i]);
        }
        int ans = high;
        // int maxi = high;

        while(low<= high){
            int mid = low + (high-low)/2;
            boolean flag = helper(nums, maxOperations, mid);
            if(flag == true){
                high = mid-1;
                ans = mid;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean helper(int[] nums, int n, int mid){
        // if(maxi % mid != 0) return false;
        // if((maxi/mid)-1 > n) return false;
        for(int i = 0; i< nums.length; i++){
            n = n - (int)(Math.ceil((double)nums[i]/ mid)-1);
            if(n <0) return false;
        }
        return true;

    }
}
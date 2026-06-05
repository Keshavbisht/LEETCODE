class Solution {
    public int search(int[] nums, int target) {
        return helper(0, nums.length-1, nums, target);
    }
    public int helper(int low, int high, int[] nums, int target){
        if(low > high || high >=nums.length) return -1;
        int mid = low + (high - low)/2;
        
        if(target == nums[mid]) return mid;

        if(target < nums[mid]){
            return helper(low, mid-1, nums, target);
        }
        else{
            return helper(mid+1, high, nums, target);
        }
        
    }
}
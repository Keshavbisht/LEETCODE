class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int prev = -1;
        ans[0] = binary(nums, 0, nums.length-1, target);
        if(ans[0] == Integer.MAX_VALUE){
            ans[0] = -1;
        }
        ans[1] = binaryG(nums, 0, nums.length-1, target);
        return ans;
        
    }
    public int binary(int[] nums,int low, int high, int target){
        // int low = 0;
        // int high = nums.length-1;
        if(low > high) return Integer.MAX_VALUE;
        int mid = low + (high - low)/2;
        if(nums[mid] == target){
            return Math.min(mid, binary(nums, low, mid-1, target));
        }
        if(nums[mid] > target){
            return binary(nums, low, mid-1, target);
        }
        else if(nums[mid] < target){ 
            return binary(nums, mid+1, high, target);
        }
        return Integer.MAX_VALUE;

    }
    public int binaryG(int[] nums,int low, int high, int target){
        // int low = 0;
        // int high = nums.length-1;
        if(low > high) return -1;
        int mid = low + (high - low)/2;
        if(nums[mid] == target){
            return Math.max(mid, binaryG(nums, mid+1, high, target));
        }
        if(nums[mid] > target){
            return binaryG(nums, low, mid-1, target);
        }
        else if(nums[mid] < target){
            return binaryG(nums, mid+1, high, target);
        }
        return -1;

    }
}
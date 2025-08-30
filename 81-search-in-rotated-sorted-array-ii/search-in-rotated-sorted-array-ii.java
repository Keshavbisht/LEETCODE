class Solution {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        return binary(0, nums.length-1, nums, target);
    }
    public boolean binary(int low, int high ,int[] nums, int target){
         if (low > high) return false;
        int mid = (low+high)/2;
        if(nums[mid] == target) return true;
        boolean x = true;
        if(nums[mid] > target){
            x = binary(low, mid-1, nums, target);
        }
        else{
            x=  binary(mid+1, high, nums, target);
        }
        return x;
    }
}
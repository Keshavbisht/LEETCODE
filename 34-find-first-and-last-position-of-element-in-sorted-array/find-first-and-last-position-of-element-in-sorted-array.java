class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int prev = -1;
        for(int i = 0; i< nums.length; i++){
            if(ans[0] == -1 && nums[i]==target){
                ans[0] = i;
            }
            if(nums[i] == target){
                prev = i;
            }
        }
        ans[1] = prev;
        return ans;
    }
}
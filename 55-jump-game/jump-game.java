class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length -1;
        int check = nums.length -2;
        while(check >= 0){
            if(check + nums[check] >= target){
                target = check;
            }
            check--;
        }
        if(target != 0) return false;
        return true;
    }
}
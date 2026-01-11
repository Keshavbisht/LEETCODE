class Solution {
    public void rotate(int[] nums, int k) {
        int pnt1 = nums.length-1;
        k = k % nums.length;

        helper(0,nums.length-1, nums);
        helper(0, k-1, nums);
        helper(k, nums.length-1, nums);
    }
    void helper(int start, int end, int[] nums){
        while(start< end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
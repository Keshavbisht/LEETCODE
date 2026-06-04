class Solution {
    public void moveZeroes(int[] nums) {
        int pnt1 = 0;

        for(int i = 0; i< nums.length; i++){


            if(nums[i] != 0 && i != pnt1){
                nums[pnt1] = nums[i];
                nums[i] = 0;
                pnt1++;
            }
            else if(nums[i] != 0 && pnt1 == i){
                pnt1++;
            }
        }
    }
}
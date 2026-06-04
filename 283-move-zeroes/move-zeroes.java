class Solution {
    public void moveZeroes(int[] nums) {
        int pnt1 = -1;
        // int pnt2 = 0;

        while(pnt1 < nums.length-1){
            pnt1++;
            int pnt2 = pnt1;
            while(nums[pnt1] == 0 && pnt2 < nums.length-1){
                pnt2++;
                if(nums[pnt2] !=0){
                    nums[pnt1] = nums[pnt2];
                    nums[pnt2] = 0;
                }
            }
        }
        

    }
}
class Solution {
    public int[] singleNumber(int[] nums) {
        // if(nums.equals([-1, 2147483647])) return new int[]{0,-2147483648};
        int x = 0;
        int y = 0;

        int temp = 0;
        for(int i = 0; i< nums.length; i++){
            temp = temp ^ nums[i];
        }
        int bit = temp & -temp ;
        for(int i = 0; i< nums.length; i++){
            if((bit & nums[i]) !=0){
                x = x ^ nums[i];
            }
            else{
                y = y ^ nums[i];
            }
        }
        return new int[]{x, y};
    }
}
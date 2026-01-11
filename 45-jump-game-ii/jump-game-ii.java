class Solution {
    public int jump(int[] nums) {
        int curr = 0;
        int maxi = 0;
        int steps = 0;
        if(nums.length == 1) return 0;
        for(int i = 0; i< nums.length-1; i++){
            if(maxi< i) return 0;
            maxi = Math.max(maxi, nums[i]+i);
            if(curr == i){
                steps++;
                curr = maxi;
            }
        }
        return steps;
    }
}
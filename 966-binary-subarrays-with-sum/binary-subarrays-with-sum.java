class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal-1);
    }
    int helper(int[] nums, int goal){
        int n = nums.length;
        int a =  0;
        int b = -1;

        int temp = 0;
        int ans = 0;
        while(b < n-1){
            b++;
            temp = temp+ nums[b];
            while(a<=b && temp > goal){
                temp = temp - nums[a];
                a++;
            }
            ans += b-a+1;
        }
        return ans;
    }
}
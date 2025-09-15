class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0; i< n; i++){
            if(nums[i]%2 == 0){
                nums[i] = 0;
            }
            else{
                nums[i] = 1;
            }
        }

        return helper(nums, k) - helper(nums, k-1);

    }
    public int helper(int[] nums, int goal){
        int a = 0;
        int b = -1;
        int n = nums.length;
        int temp = 0;
        int ans = 0;
        while(b< n-1){
            b++;
            temp = temp + nums[b];
            while(a<=b && temp > goal){
                if(nums[a] == 1){
                    temp--;
                }
                a++;
            }
            ans = ans + (b-a +1);
        }
        return ans;
    }
}
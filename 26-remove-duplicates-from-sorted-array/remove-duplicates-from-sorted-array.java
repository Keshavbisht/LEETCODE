class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int a = 0;
        int b = 1;
        int ans = 0;
        while(b <=n-1 && a <= n-1){
            if(nums[a] != nums[b]){
                nums[a+1] = nums[b];
                a = a+1;
                b = b+1;
                ans++;
            }
            else{
                b = b+1;
            }
        }
        return ans + 1;
    }
}
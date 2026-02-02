class Solution {
    int ans = -1;
    public int minimumK(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long low = 1;
        long high = Integer.MAX_VALUE;
        while( low<=high){
            long mid = low + (high - low)/2;
            if(helper(mid, nums)){
                ans = (int) mid;
                high = mid-1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;

    }
    public boolean helper(long target, int[] nums){
        // System.out.println("TARGET = "+target);
        int curr = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i]%target == 0){
                curr = curr + (int)(nums[i]/target);
            }
            else{
                curr = curr + (int)(nums[i]/target) +1;
            }
            // curr = curr + (int)Math.floor(nums[i]/target);
            // System.out.println(curr);
            if(curr > target*target) return false;
        }
        return true;
    }
}
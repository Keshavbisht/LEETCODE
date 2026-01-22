class Solution {
    public int[] getAverages(int[] nums, int k) {
        long prefix = 0;
        long[] prefixArr = new long[nums.length]; 
        for(int i = 0; i<nums.length; i++){
            prefix += nums[i];
            prefixArr[i]  = prefix;
        }
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        int left = 0;
        int mid = k;
        int right = mid+k;
        while(right<= nums.length-1){
            long temp = 0;
            if(left - 1 >=0){
                temp = prefixArr[right] - prefixArr[left-1];
                ans[mid] = (int)(temp / (2*k+1));
            }
            else{
                temp = prefixArr[right];
                ans[mid] = (int)(temp / (2*k+1));
            }
            mid++;
            left++;
            right++;

        }
        return ans;

    }
}
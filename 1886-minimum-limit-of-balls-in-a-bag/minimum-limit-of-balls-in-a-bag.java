class Solution {
    int maxi = 0;
    public int minimumSize(int[] nums, int m) {
        int low = 1;
        int high = -1;

        for(int i = 0; i< nums.length; i++){
            high = Math.max(high, nums[i]);
        }
        int ans = 0;
        maxi =high;

        while(low <= high){
            int mid = low + (high -low)/2;

            boolean flag = helper(mid, nums, m);
            if(flag){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;

    }
    public boolean helper(int a, int[] nums, int m){
        System.out.println(a);
        for(int i = 0; i< nums.length; i++){
             m -= (int) Math.ceil((double)nums[i]/ a) -1;
             if(m < 0) return false;
        }
        // System.out.println(temp);
        // if(temp <= m) return true;
        if(m < 0) return false;

        return true;
    }
}
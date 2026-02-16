class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        int pnt1 =0;
        int pnt2 = -1;
        long sum1 = 0;

        long ans = Integer.MIN_VALUE;
        while(pnt2 < n-1){
            pnt2++;
            while(set.contains(nums[pnt2]) || set.size() ==k){
                sum1 -= nums[pnt1];
                set.remove(nums[pnt1]);
                pnt1++;
            }
            set.add(nums[pnt2]);
            sum1 += nums[pnt2];
            if(set.size() == k){
                ans = Math.max(ans, sum1);
            }

        }
        return (ans == Integer.MIN_VALUE) ? 0 : ans;
    }
}
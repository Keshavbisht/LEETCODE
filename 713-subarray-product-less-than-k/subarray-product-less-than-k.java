class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) return 0;

        int pnt1 = 0;
        long prod = 1;
        int ans = 0;

        for (int pnt2 = 0; pnt2 < nums.length; pnt2++) {

            prod *= nums[pnt2];

            while (prod >= k && pnt1 <= pnt2) {
                prod /= nums[pnt1];
                pnt1++;
            }

            ans += (pnt2 - pnt1 + 1);
        }

        return ans;
    }
}

class Solution {
    public long maxProduct(int[] nums) {
        int maxN = 0;
        for (int x : nums)
            maxN = Math.max(maxN, x);
        int MAXX = (int) (Math.log(maxN) / Math.log(2)) + 1;
        int[] dp = new int[1 << MAXX];
        for (int x : nums)
            dp[x] = x;
        for (int bit = 0; bit < MAXX; bit++)
            for (int mask = 0; mask < (1 << MAXX); mask++)
                if (((mask >> bit) & 1) == 1)
                    dp[mask] = Math.max(dp[mask], dp[mask ^ (1 << bit)]);
        long ans = 0;
        for (int x : nums)
            ans = Math.max(ans, 1L * x * dp[((1 << MAXX) - 1) ^ x]);
        return ans;
    }
}
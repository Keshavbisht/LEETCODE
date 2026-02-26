class Solution {
    int MOD = 1000000007;
    public int numWays(int steps, int arrLen) {
        int maxPos = Math.min(arrLen - 1, steps);
        long[][] dp = new long[maxPos + 1][steps + 1];
        for(long[] itr: dp){
            Arrays.fill(itr, -1);
        }
        return (int) helper(0, steps, arrLen, dp) % MOD;
    }
    public long helper(int ind, int steps, int arrLen, long[][] dp){
        
        if(ind <0 || ind >= arrLen) return 0;
        if(steps < 0) return 0;
        int ans = 0;
        if(dp[ind][steps] != -1) return dp[ind][steps];
        if(steps == 0){
            // ans = 1;
            return (ind == 0) ? 1 : 0;
        }

        // ans += helper(ind, steps-1, arrLen);
        // ans += helper(ind-1, steps-1, arrLen);
        // ans += helper(ind+1, steps-1, arrLen);

        return dp[ind][steps] = helper(ind, steps-1, arrLen, dp) % MOD + helper(ind-1, steps-1, arrLen, dp) % MOD + helper(ind+1, steps-1, arrLen, dp) % MOD;
    }
}
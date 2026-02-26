class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(helper(n-1, cost, dp), helper(n-2, cost, dp));
    }
    public int helper(int ind, int[] cost, int[] dp){
        if(ind < 0) return 0;
        if(ind == 0) return cost[0];
        if(ind == 1) return cost[1];
        if(dp[ind] != -1) return dp[ind];

        int a = helper(ind-1, cost, dp);
        int b = helper(ind -2, cost, dp);

        return dp[ind] = Math.min(a, b) + cost[ind];
    }
}
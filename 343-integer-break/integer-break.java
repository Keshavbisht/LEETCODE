class Solution {
    int[] dp;
    public int integerBreak(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(0, n);
    }
    public int helper(int curr, int n){
        if(curr == n) return 1;
        if(dp[curr] != -1) return dp[curr];
        int maxi = 0;
        for(int i = n-1; i>0; i--){
            if(curr + i <= n){
                int a = helper(i+curr, n);
                if(a > 0){
                    maxi = Math.max(maxi, i * helper(i+curr, n));
                }
            }
        }
        return dp[curr] = maxi;
    }
}
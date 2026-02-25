class Solution {
    // int ans = 0;
    int MOD = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        Arrays.fill(dp, -1);
        

        return helper(0, low, high, zero, one, dp)%MOD;
    }
    public int helper(int ind, int low, int high, int zero, int one, int[] dp){
        if(ind > high) return 0;
        int ans = 0;
        if(ind >= low){
            ans++;
        }
        int takeZero = Integer.MIN_VALUE;
        int takeOne = Integer.MIN_VALUE;
        if(dp[ind] != -1) return dp[ind];
        
        
 
        ans  = ans + helper(ind + zero, low , high, zero, one, dp)% MOD;
        ans = ans + helper(ind + one, low, high, zero, one, dp)%MOD;
        

        return dp[ind] = ans;
    }
}
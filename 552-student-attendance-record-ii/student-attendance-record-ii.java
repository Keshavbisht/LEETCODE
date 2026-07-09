class Solution {
    int MOD = 1000000007;
    long dp[][][];
    public int checkRecord(int n) {
        dp = new long[n+1][2+1][3+1];
        for(long[][] i: dp){
            for(long[] itr: i){
                Arrays.fill(itr, -1);
            }
        }
        return (int) helper(0, n, 0, 0) % MOD;
    }
    public long helper(int ind, int n, int countAbs, int late){
        if(countAbs >= 2 || late >= 3) return 0;
        if(ind == n) return 1;
        if(dp[ind][countAbs][late] != -1) return dp[ind][countAbs][late];
        if(ind > n) return 0;


        long a = helper(ind+1, n, countAbs, 0) % MOD;
        long b = helper(ind+1, n, countAbs+1, 0) % MOD;
        long c = helper(ind+1, n, countAbs, late+1) % MOD;

        return dp[ind][countAbs][late] = (a+b+c) % MOD;
    }
}
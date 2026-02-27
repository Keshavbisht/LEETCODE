class Solution {
    int MOD = 1000000007;
    public int checkRecord(int n) {
        long[][][] dp = new long[n+1][2+1][3+1];
        for(long[][] itr1 : dp){
            for(long[] itr2: itr1){
                Arrays.fill(itr2, -1);
            }
        }

        return (int) helper(0, n, 0, 0, dp) % MOD;

    }
    public long helper(int ind, int n, int countAbs, int contLate , long[][][] dp){
        if(countAbs >= 2 || contLate >=3) return 0;
        if(ind == n) return 1;
        if(dp[ind][countAbs][contLate] != -1) return dp[ind][countAbs][contLate];

        long a = 0;
        long b= 0;
        long c = 0;

        
        a = helper(ind+1, n, countAbs, 0, dp) %MOD;
        b = helper(ind+1, n, countAbs +1, 0, dp) %MOD;
        c = helper(ind+1, n, countAbs, contLate+1, dp) %MOD;
        
        return dp[ind][countAbs][contLate] = (a+b+c) %MOD;
    }
}
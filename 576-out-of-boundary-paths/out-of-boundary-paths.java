class Solution {
    int MOD = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long[][][] dp = new long[m+1][n+1][maxMove+1]; 
        for(long[][] itr: dp){
            for(long[] itr2 : itr){
                Arrays.fill(itr2, -1);
            }
            
        }
        return (int) helper(startRow, startColumn, maxMove, m, n, dp) % MOD;
    }
    public long helper(int i, int j, int maxMove, int m, int n, long[][][] dp){
        if(maxMove<=0){
            if(i < 0 || i >= m || j < 0 || j>= n ) return 1;
            return 0;
        }
        
        if(i < 0 || i >= m || j < 0 || j>= n ) return 1;
        if(dp[i][j][maxMove] != -1) return dp[i][j][maxMove];
        

        long a = helper(i-1, j, maxMove - 1, m, n, dp) % MOD; // up
        long b = helper(i+1, j, maxMove -1,  m, n, dp) % MOD; //dowm
        long c = helper(i, j-1, maxMove -1,  m, n, dp) % MOD; // left
        long d = helper(i, j+1, maxMove -1,  m, n, dp) % MOD; // right

        return dp[i][j][maxMove] = (a+b+c+d) % MOD;

    }
}
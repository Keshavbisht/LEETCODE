class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
    
        dp = new int[m][n];
        for(int[] itr: dp){
            Arrays.fill(itr, -1);
        }
        return helper(0,0, m,n);
    }
    public int helper(int i, int j, int m, int n){
        if(i == m-1 && j == n-1) return 1;
    
        if(i < 0 || i >= m || j < 0 || j>= n ) return 0;
        // if(grid[i][j] == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int a = helper(i+1, j, m,n);
        int b = helper(i, j+1, m,n);

        return dp[i][j] = a+b;

    }
}
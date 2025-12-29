class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] itr: dp){
            Arrays.fill(itr, -1);
        } 
        return helper(m-1, n-1, grid, dp);
    }
    public int helper(int i , int j, int[][] grid, int[][] dp){
        if(i <0 || j<0) return Integer.MAX_VALUE;
        if(i == 0 && j==0) return grid[0][0];
        if(dp[i][j] != -1) return dp[i][j];
        
        return dp[i][j] = grid[i][j] + Math.min(helper(i-1, j, grid, dp), helper(i, j-1, grid, dp));
    }
}
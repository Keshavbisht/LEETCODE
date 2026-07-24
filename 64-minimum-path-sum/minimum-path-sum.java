class Solution {
    int n,m;
    int[][] dp;
    public int minPathSum(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m];
        for(int[] itr: dp){
            Arrays.fill(itr, -1);
        }

        return helper(n-1, m-1, grid);
    }
    public int helper(int i, int j, int[][] grid){
        if(i < 0 || i >= n || j < 0 || j >=m) return Integer.MAX_VALUE;
        if(i ==0 && j == 0) return grid[0][0];
        if(dp[i][j] != -1) return dp[i][j];

        int left = helper(i, j-1, grid);
        int up = helper(i-1, j, grid);

        return dp[i][j] = Math.min(left, up) + grid[i][j];
    }
}
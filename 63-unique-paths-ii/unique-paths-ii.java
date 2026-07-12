class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        if( grid[grid.length-1][grid[0].length-1] == 1) return 0;
        dp = new int[grid.length][grid[0].length];
        for(int[] itr: dp){
            Arrays.fill(itr, -1);
        }
        return helper(0,0, grid);
    }
    public int helper(int i, int j, int[][] grid){
        if(i == grid.length-1 && j == grid[0].length-1) return 1;
    
        if(i < 0 || i >= grid.length || j < 0 || j>= grid[0].length ) return 0;
        if(grid[i][j] == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int a = helper(i+1, j, grid);
        int b = helper(i, j+1, grid);

        return dp[i][j] = a+b;



    }
}
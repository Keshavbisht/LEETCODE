class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for(int itr[] : dp){
            Arrays.fill(itr, -1);
        }
        return helper(0,0, grid);
    }
    public int helper(int i, int j, int[][] grid){
        if(i == grid.length-1 && j == grid[0].length-1) return grid[i][j];
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];


        int a = helper(i+1, j, grid);
        int b = helper(i, j+1, grid);

        return dp[i][j] = Math.min(a,b) + grid[i][j];


    }
}
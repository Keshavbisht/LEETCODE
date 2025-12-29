class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MAX_VALUE;

        int[][] dp = new int[m][n];
        for(int[] itr: dp){
            Arrays.fill(itr, Integer.MAX_VALUE);
        }
        
        for(int j = 0; j< matrix[0].length; j++){
            ans = Math.min(ans, helper(0,j,matrix,m,n, dp));
        }
        
        return ans;

    }
    public int helper(int i,int j, int[][] matrix, int m, int n, int[][] dp){
        if(i<0 || j< 0 || i>= m || j >= n) return Integer.MAX_VALUE;

        if(i == m-1 && j<n) return matrix[i][j];
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        dp[i][j] = matrix[i][j] + Math.min(helper(i+1, j-1, matrix, m,n, dp),Math.min(helper(i+1,j, matrix,m,n, dp), helper(i+1, j+1, matrix, m,n, dp)));
        return dp[i][j];

    }
}
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];
        for(int[] itr: dp){
            Arrays.fill(itr, -2);
        }

        for(int i = 0; i< n; i++){
            ans = Math.min(ans, helper(0, i, matrix, dp));
        }
        return ans;
    }
    public int helper(int i, int j, int[][] matrix, int[][] dp){
        if(i>=matrix.length || j<0 || j>=matrix[0].length) return Integer.MAX_VALUE;
        if(dp[i][j] != -2) return dp[i][j];
        if(i == matrix.length-1) return matrix[i][j];
        
        
        return dp[i][j] = matrix[i][j] + Math.min(helper(i+1, j, matrix, dp), Math.min(helper(i+1, j+1, matrix, dp), helper(i+1,j-1, matrix, dp)));
    }
}
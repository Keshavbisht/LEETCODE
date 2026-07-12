class Solution {
    int dp[][];
    public int minFallingPathSum(int[][] matrix) {
        dp = new int[matrix.length+1][matrix[0].length+1];
        for(int[] itr : dp){
            Arrays.fill(itr, -10000);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i< matrix.length; i++){
            ans = Math.min(ans, helper(0, i, matrix));
        }
        return ans;
    }
    public int helper(int i,int j,  int[][] matrix){
        if(i == matrix.length-1 && (j>=0) && j<matrix[0].length) return matrix[i][j];
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return Integer.MAX_VALUE;
        if(dp[i][j] != -10000) return dp[i][j];

        int a = helper(i+1, j+1, matrix);
        int b = helper(i+1, j, matrix);
        int c = helper(i+1, j-1, matrix);

        return dp[i][j] = Math.min(a, Math.min(b,c)) + matrix[i][j];


    }
}
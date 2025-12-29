class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] itr:dp ){
            Arrays.fill(itr, -1);
        }
        return helper(m-1, n-1, arr, dp);

    }
    public int helper(int i, int j, int[][] arr, int[][] dp){
        if(i<0 || j<0 || arr[i][j] == 1) return 0;
        if(i == 0 && j==0) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j]= helper(i-1, j, arr,dp) + helper(i, j-1, arr, dp);
    }
}
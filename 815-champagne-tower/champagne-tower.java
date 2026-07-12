class Solution {
    double[][] dp;
    public double champagneTower(int curr, int m, int n) {
        dp = new double[m][m+1];
        if(m == 0 && n == 0 && curr >=1 ) return 1; 
        for(double[] itr: dp){
            Arrays.fill(itr, -1);
        }
        double left = helper(m- 1, n - 1, curr);
        double right = helper(m - 1, n, curr);

        double received = left / 2.0 + right / 2.0;
        return Math.min(1.0, received);
    }
    public double helper(int i, int j, int curr){
        if(i == 0 && j == 0){
            return Math.max(0.0, (curr-1.0));
        }
        if(i < 0 || j < 0 || j > i) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        double a = helper(i-1, j-1,curr) /2.0;
        double b = helper(i-1, j, curr)/ 2.0;
        System.out.println(a);
        System.out.println(b);

        return dp[i][j] = Math.max(0.0, a+b -1);




    }
}
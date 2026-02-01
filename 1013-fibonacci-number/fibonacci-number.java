class Solution {
    public int fib(int n) {
        // if(n<=1) return n;
        // return fib(n-1) + fib(n-2);

        // int a = 0;
        // int b = 1;
        // int c = 0;
        // for(int i = 0; i< n-1; i++){
        //     c = a + b;
        //     a = b;
        //     b = c;
        //     System.out.print(c + " ");
        // }
        // return 0;
        int [] dp= new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
        
    }
    public int helper(int n, int[] dp){
        if(n<=1) return n;
        if(dp[n] != -1) return dp[n];

        return dp[n] = helper(n-1, dp) + helper(n-2, dp);
    }
}
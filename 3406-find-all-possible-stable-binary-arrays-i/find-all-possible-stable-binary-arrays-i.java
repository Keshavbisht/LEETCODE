class Solution {

    int MOD = 1000000007;
    int[][][] dp;

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new int[zero + 1][one + 1][2];
        for(int i=0;i<=zero;i++)
            for(int j=0;j<=one;j++)
                dp[i][j][0] = dp[i][j][1] = -1;

        long ans = (dfs(zero, one, 0, limit) + dfs(zero, one, 1, limit)) % MOD;
        return (int)ans;
    }

    long dfs(int z, int o, int last, int limit){

        if(z < 0 || o < 0) return 0;
        if(z==0 && o==0) return 1;
        if(dp[z][o][last] != -1) return dp[z][o][last];
        long ans = 0;
        if(last == 0){
            for(int i=1;i<=limit;i++){
                if(z-i < 0) break;
                ans = (ans + dfs(z-i, o, 1, limit)) % MOD;
            }
        }
        else{
            for(int i=1;i<=limit;i++){
                if(o-i < 0) break;
                ans = (ans + dfs(z, o-i, 0, limit)) % MOD;
            }
        }

        return dp[z][o][last] = (int)ans;
    }
}

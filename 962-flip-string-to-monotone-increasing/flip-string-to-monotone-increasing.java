class Solution {
    public int minFlipsMonoIncr(String s) {
        int[][] dp = new int[s.length() +1][2];
        for(int[] itr: dp){
            Arrays.fill(itr, -1);
        }
        return helper(0, s, 0, dp);
    }
    public int helper(int ind, String s, int prev, int[][] dp){
        int n = s.length();
        if(ind == n) return 0;
        if(dp[ind][prev] != -1) return dp[ind][prev];
        int flip = Integer.MAX_VALUE;
        int noFlip = Integer.MAX_VALUE;
        if(s.charAt(ind) == '0'){
            if(prev == 1){
                flip = 1 + helper(ind+1, s,1, dp);
            }
            else{
                flip = 1 + helper(ind+1, s, 1, dp);
                noFlip = helper(ind+1, s, 0, dp);
            }
        }
        else if(s.charAt(ind) == '1'){
            if(prev == 1){
                noFlip = helper(ind+1, s, 1, dp);
            }
            else{
                flip = 1 + helper(ind+1, s, 0, dp);
                noFlip = helper(ind+1, s, 1, dp);
            }
        }
        return dp[ind][prev] = Math.min(flip, noFlip);
    }
}
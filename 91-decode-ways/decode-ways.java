class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() +1];
        Arrays.fill(dp, -1);
        return helper(0, s, dp);
    }
    public int helper(int ind, String s, int[] dp){
        if(ind == s.length()) return 1;

        int a = 0;
        int b= 0;
        if(s.charAt(ind) - '0' == 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        
        a = helper(ind+1, s, dp);
        
        if(s.length() - ind >= 2 && Integer.parseInt(s.substring(ind, ind+2)) <=26){
            b = helper(ind+2, s, dp);
        }
        return dp[ind] = a+b;
    }
}
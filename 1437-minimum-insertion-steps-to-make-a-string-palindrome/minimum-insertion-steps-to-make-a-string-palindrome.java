
class Solution {
    public int minInsertions(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int[] itr: dp){
            Arrays.fill(itr, -1);
        }
        int lps = lcsRec(s, s2, n, n, dp);
        return n - lps;
    }

    private int lcsRec(String s1, String s2, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            return 1 + lcsRec(s1, s2, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(lcsRec(s1, s2, i - 1, j, dp), lcsRec(s1, s2, i, j - 1, dp));
        }
    }
}

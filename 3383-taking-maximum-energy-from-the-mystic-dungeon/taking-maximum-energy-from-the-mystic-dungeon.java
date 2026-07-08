class Solution {
    int[] dp;
    public int maximumEnergy(int[] energy, int k) {
        int ans  = Integer.MIN_VALUE;
        dp = new int[energy.length];
        Arrays.fill(dp, -1);
        for(int i = 1; i<= k; i++){
            ans = Math.max(ans, helper(energy.length -i, energy, k));
        }
        // return Math.max(helper(energy.length-1, energy, k) ,helper(energy.length-1, energy, k));.
        return ans;
    }
    public int helper(int ind, int[] energy, int k){
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        int a = helper(ind-k, energy, k);
        if(a < 0) return energy[ind];
        return dp[ind] = a + energy[ind];
    }
}
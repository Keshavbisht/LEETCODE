class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        for(int i = 0; i< cuts.length; i++){
            arr.add(cuts[i]);
        }
        
        arr.add(n);
        Collections.sort(arr);
        int[][] dp = new int[arr.size()+1][arr.size()+1];
        for(int[] itr: dp){
            Arrays.fill(itr, -1);
        }
        
        return helper(1,arr.size()-2,arr, dp );
        
        
    }
    public int helper(int i, int j, List<Integer> arr, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int minValue = Integer.MAX_VALUE;
        for(int k = i; k<=j; k++){
            int cost = (arr.get(j+1) - arr.get(i-1)) + helper(i, k-1, arr, dp) + helper(k+1, j, arr, dp);
            minValue = Math.min(minValue,cost);
        }

        return dp[i][j] = minValue;
    }
}
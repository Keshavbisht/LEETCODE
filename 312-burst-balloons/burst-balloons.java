class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        for(int i = 0; i< nums.length; i++){
            arr.add(nums[i]);
        }
        
        arr.add(1);
        // Collections.sort(arr);
        int[][] dp = new int[arr.size()][arr.size()];
        for(int[] itr: dp){
            Arrays.fill(itr, -1);
        }
        
        return helper(1,arr.size()-2,arr, dp );
    }
    public int helper(int i, int j, List<Integer> arr, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int minValue = Integer.MIN_VALUE;
        for(int k = i; k<=j; k++){
            int cost = (arr.get(i-1)*arr.get(k)*arr.get(j+1)) + helper(i, k-1, arr, dp) + helper(k+1, j, arr, dp);
            minValue = Math.max(minValue,cost);
        }

        return dp[i][j] = minValue;
    }
    
}
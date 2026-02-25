class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length+1];
        Arrays.fill(dp, -1);
        return helper(0,questions, dp);
    }
    public long helper(int ind ,int[][] questions , long[] dp){
        if(ind >= questions.length) return 0;
        if(dp[ind] != -1) return dp[ind];
        long take = Integer.MIN_VALUE;
        long notTake = Integer.MIN_VALUE;
        
        take = questions[ind][0] + helper(ind+1+ questions[ind][1], questions, dp);
        notTake = helper(ind+1, questions, dp);
        
        // else{
            // take = questions[ind][0] + helper(ind+1, questions[ind][1], questions);
            // take = helper(ind+1, skip-1, questions, dp);
            // notTake = helper(ind+1, 0, questions);
        // }

        return dp[ind] = Math.max(take, notTake);
    }
}
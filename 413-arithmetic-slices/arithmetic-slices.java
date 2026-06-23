class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        HashMap<Long, Integer>[] dp = new HashMap[n];
        for(int i = 0; i<n; i++){
            dp[i] = new HashMap<>();
        }

        int ans = 0;

        for(int i = 1; i< n; i++){

            for(int j = i-1; j< i; j++){

                long temp = (long) nums[i] - nums[j];

                if(dp[i-1].containsKey(temp)){
                    ans = ans + dp[i-1].get(temp);
                }
                dp[i].put(temp, dp[i].getOrDefault(temp, 0)+dp[i-1].getOrDefault(temp, 0)+1);
            }
        }
        return ans;
    }
}
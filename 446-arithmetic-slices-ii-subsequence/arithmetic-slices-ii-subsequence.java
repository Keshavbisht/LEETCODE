class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;

        HashMap<Long, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                long diff = (long) nums[j] - nums[i];

 
                int old = dp[j].getOrDefault(diff, 0);


                ans += old;
                dp[i].put(
                    diff,
                    dp[i].getOrDefault(diff, 0)
                    + old + 1
                );
            }
        }

        return ans;
    }
}
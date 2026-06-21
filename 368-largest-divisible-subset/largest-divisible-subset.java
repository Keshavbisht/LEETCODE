class Solution {
    Integer[][] dp;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        dp = new Integer[n][n + 1];

        // Fill memo table
        helper(0, -1, nums);

        // Reconstruct answer
        List<Integer> ans = new ArrayList<>();

        int ind = 0;
        int prev = -1;

        while (ind < n) {
            int notTake = helper(ind + 1, prev, nums);

            int take = -1;
            if (prev == -1 || nums[ind] % nums[prev] == 0) {
                take = 1 + helper(ind + 1, ind, nums);
            }

            if (take >= notTake) {
                ans.add(nums[ind]);
                prev = ind;
            }

            ind++;
        }

        return ans;
    }

    private int helper(int ind, int prev, int[] nums) {
        if (ind == nums.length) {
            return 0;
        }

        if (dp[ind][prev + 1] != null) {
            return dp[ind][prev + 1];
        }

        int notTake = helper(ind + 1, prev, nums);

        int take = 0;
        if (prev == -1 || nums[ind] % nums[prev] == 0) {
            take = 1 + helper(ind + 1, ind, nums);
        }

        return dp[ind][prev + 1] = Math.max(take, notTake);
    }
}
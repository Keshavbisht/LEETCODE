import java.util.*;

class Solution {
    Map<String, Integer> dp;

    public int minRemovals(int[] nums, int target) {
        dp = new HashMap<>();
        int ans = helper(0, 0, nums, target);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public int helper(int ind, int curr, int[] nums, int target) {
        if (ind == nums.length) {
            return (curr == target) ? 0 : Integer.MAX_VALUE;
        }

        String key = ind + "," + curr;
        if (dp.containsKey(key)) return dp.get(key);

        int take = helper(ind + 1, curr ^ nums[ind], nums, target);

        int notTake = helper(ind + 1, curr, nums, target);
        if (notTake != Integer.MAX_VALUE) {
            notTake += 1;
        }

        int res = Math.min(take, notTake);
        dp.put(key, res);

        return res;
    }
}
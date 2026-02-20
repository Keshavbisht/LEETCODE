class Solution {
    public long countGood(int[] nums, int k) {

        long ans = 0;
        int n = nums.length;
        int pnt1 = 0;
        int pnt2 = -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        long pairs = 0;

        while (pnt2 < n - 1) {

            pnt2++;

            int freq = map.getOrDefault(nums[pnt2], 0);
            pairs += freq;
            map.put(nums[pnt2], freq + 1);

            while (pnt1 <= pnt2 && pairs >= k) {
                ans += (n - pnt2);
                int leftFreq = map.get(nums[pnt1]);
                pairs -= (leftFreq - 1);
                map.put(nums[pnt1], leftFreq - 1);

                pnt1++;
            }
        }

        return ans;
    }
}

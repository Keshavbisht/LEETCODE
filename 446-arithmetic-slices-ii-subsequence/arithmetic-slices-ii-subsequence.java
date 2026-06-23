class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        HashMap<Long, Integer>[] dp = new HashMap[n];
        for(int i = 0; i<n; i++){
            dp[i] = new HashMap<>();
        }

        int ans = 0;

        for(int i = 0; i< n; i++){

            for(int j = 0; j< i; j++){

                long temp = (long) nums[i] - nums[j];

                if(dp[j].containsKey(temp)){
                    ans = ans + dp[j].get(temp);
                }
                dp[i].put(temp, dp[i].getOrDefault(temp, 0)+dp[j].getOrDefault(temp, 0)+1);
            }
        }

        // for(int i = 0; i< n; i++){
        //     System.out.println(i);
        //     for(Map.Entry<Long, Integer> entry: dp[i].entrySet()){
        //         System.out.println(entry.getKey()+" "+entry.getValue());
        //     }
        // }
        return ans;
    }
}
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix = 0;
        int ans = 0;
        map.put(0,1);
        for(int i = 0; i< nums.length; i++){
            prefix = prefix + nums[i];
            if(map.containsKey(prefix - k)){
                ans = ans + map.get(prefix - k);
                // map.put(prefix, map.get(prefix-k) +1);
            }
            if(map.containsKey(prefix)){
                map.put(prefix, map.get(prefix)+1);
            }
            else{
                map.put(prefix, 1);
            }
        }
        return ans;
    }
}
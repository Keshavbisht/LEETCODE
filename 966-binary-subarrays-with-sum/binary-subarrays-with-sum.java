class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0;
        int ans = 0;
        for(int i = 0; i< nums.length; i++){
            prefix = prefix + nums[i];
            if(map.containsKey(prefix - goal)){
                ans = ans + map.get(prefix - goal);
            }
            if(map.containsKey(prefix)){
                map.put(prefix , map.get(prefix)+1);
            }
            else{
                map.put(prefix, 1);
            }
        }
        return ans;
    }
}
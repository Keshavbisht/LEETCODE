class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i = 0; i< nums.length; i++){
            if(nums[i] % 2 == 0){
                nums[i] = 0;
            }
            else{
                nums[i] = 1;
            }
        }
        int pnt2 = -1;
        int pnt1 = 0;
        int ans = 0;
        int prefix = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        while(pnt2<nums.length -1){
            pnt2++;
            prefix = prefix + nums[pnt2];
            if(map.containsKey(prefix - k)){
                ans = ans + map.get(prefix - k);
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
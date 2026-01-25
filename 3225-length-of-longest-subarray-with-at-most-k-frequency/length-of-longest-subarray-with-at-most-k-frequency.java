class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int pnt1 = 0;
        
        for(int pnt2 = 0; pnt2 < nums.length; pnt2++){
            if(map.containsKey(nums[pnt2])){
                
                // else{
                //     // map.put(nums[pnt2], map.get(nums[pnt2]) +1);
                // }
                map.put(nums[pnt2], map.get(nums[pnt2]) +1);
                
            }
            else{
                map.put(nums[pnt2], 1);
            }
            while(map.get(nums[pnt2]) > k){
                    int temp = nums[pnt1];
                    if(map.get(temp)-1 <=0){
                        map.remove(temp);
                    }
                    else{
                        map.put(temp,  map.get(temp)-1);
                    
                }
                pnt1++;

            }
            ans = Math.max(ans, pnt2 - pnt1 + 1);
        }
        return ans;
    }
}
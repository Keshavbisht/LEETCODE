class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
    public int helper(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int pnt1 = 0;
        int pnt2 = -1;
        int count = 0;
        int ans = 0;

        while(pnt2 < nums.length -1){
            pnt2++;
            int curr = nums[pnt2];
            if(map.containsKey(nums[pnt2])){
                map.put(curr, map.get(curr)+1);
            }
            else{
                map.put(curr, 1);
                count++;
            }

            while(count >k){
                int curr2 = nums[pnt1];
                map.put(curr2, map.get(curr2)-1);
                if(map.get(curr2) <= 0){
                    map.remove(curr2);
                    count--;
                }
                pnt1++;
            }
            ans = ans +(pnt2 - pnt1 +1);


        }
        return ans;
    } 

}

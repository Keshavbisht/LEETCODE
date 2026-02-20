class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        for(int i = 0; i< n; i++){
            set.add(nums[i]);
        }
        int unique = set.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        int pnt1 = 0;
        int pnt2 = -1;
        int ans = 0;


        while(pnt2 < n-1){
            pnt2++;
            map.put(nums[pnt2], map.getOrDefault(nums[pnt2], 0)+1);

            while(map.size() == unique){
                ans = ans + (n- pnt2);

                map.put(nums[pnt1], map.get(nums[pnt1])-1);
                if(map.get(nums[pnt1]) <= 0){
                    map.remove(nums[pnt1]);
                }
                pnt1++;
            }
        }
        return ans;
    }
}
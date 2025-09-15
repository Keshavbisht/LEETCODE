class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k, nums.length) - helper(nums, k-1, nums.length);
    }
    public int helper(int[] nums, int k, int n){
        int a = 0;
        int b= -1;
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        
        while(b<n-1){
            b++;
            if(map.containsKey(nums[b])){
                map.put(nums[b], map.get(nums[b])+1); 
            }
            else{
                map.put(nums[b], 1);
            }
            while(a<=b && map.size() > k){
                int temp = map.get(nums[a]);
                if(temp -1 <=0){
                    map.remove(nums[a]);
                }
                else{
                    map.put(nums[a], temp-1);
                }
                a++;
            }
            ans= ans +(b-a+1);

        }
        return ans;
    }
}
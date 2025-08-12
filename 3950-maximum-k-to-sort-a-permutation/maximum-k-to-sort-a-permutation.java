class Solution {
    public int sortPermutation(int[] nums) {
        List<Integer> arr = new ArrayList<>();

        int[] n = new int[nums.length];
        for(int i = 0; i< n.length; i++){
            n[i] = nums[i];
        }
        Arrays.sort(n);
        for(int i = 0; i< n.length; i++){
            if(nums[i] != n[i]){
                arr.add(nums[i]);
            }
        }
        if(arr.size() == 0) return 0;
        int ans = arr.get(0);
        for(int i = 1; i< arr.size(); i++){
            ans = ans & arr.get(i);
        }
        return ans;
        
    }
}
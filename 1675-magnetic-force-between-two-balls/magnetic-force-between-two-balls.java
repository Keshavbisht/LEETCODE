class Solution {
    HashMap<Integer, Integer> map;
    public int maxDistance(int[] nums, int m) {
        map = new HashMap<>();
        Arrays.sort(nums);
        long low = 1;
        long high = -1;
        long ans = 0;

        for(int i = 0; i< nums.length; i++){
            // map.put(nums[i], i);
            high = Math.max(high, nums[i]);
        }

        while(low <= high){
            long mid = low + (high-low)/2;

            boolean check = helper(mid, m, nums);
            if(check){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return (int) ans;
    }

    public boolean helper(long a, int m, int[] nums){
        long ans = 0;
        long last = nums[0];
        // boolean[] flag = new boolean[nums.length];

        for(int i = 1; i< nums.length; i++){
            if(nums[i] - last >= a){
                m--;
                last = nums[i];
            }
            if(m <= 1) return true;
        }
        if(m <= 1) return true;
        return false;
    }
}
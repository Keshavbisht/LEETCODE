class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] nums) {
        int n = nums.length;
        // HashMap<Integer, Integer>[] dp = new HashMap()[n];
        int[] ans = new int[n];
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.fill(ans, 1);
        // ans[0] =1;

        // for(int i = 1; i< n; i++){
        //     dp[i]= new HashMap<>();
        // }
        int l = 0;
        int h = 0;
        for(int i =0; i< n; i++){
            l = 0;
            h = arr.size();
            while(l < h){
                // h = arr.size();
                int mid = l + (h-l)/2;
                if(arr.get(mid) <= nums[i]){
                    l = mid+1;
                }
                else{
                    h = mid;
                }
            }
            int ind = l;
            if(arr.size() == ind){
                arr.add(nums[i]);
            }
            else{
                arr.set(ind, nums[i]);
            }
            ans[i] = ind+1;
        }

        // for(int i = 1; i< n; i++){
        //     for(int j = i-1; j>=0; j--){

        //         if(nums[j] == nums[i]){
        //             ans[i] = Math.max(ans[i], ans[j]+1);
        //             break;
        //         }
        //         else if(nums[j] < nums[i]){
        //             ans[i] = Math.max(ans[i], ans[j]+1);
        //             // break;
        //         }
        //     }
        // }
        return ans;
    }
}
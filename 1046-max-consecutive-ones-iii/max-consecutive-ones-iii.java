class Solution {
    public int longestOnes(int[] nums, int k) {
        int pnt1 = 0;
        int pnt2 = -1;
        int ans = -1;

        int[] arr = new int[3];
        Arrays.fill(arr, 0);

        while(pnt2 < nums.length-1){
            pnt2++;
            arr[nums[pnt2]]++;
            // if(((pnt2 - pnt1+1) - Math.max(arr[0], arr[1])) >k ){
            //     arr[nums[pnt1]]--;
            //     pnt1++;
            // }
            if(arr[0] >k ){
                arr[nums[pnt1]]--;
                pnt1++;
            }
            ans = Math.max(ans, pnt2-pnt1 + 1);
        }
        return ans;
    }
}
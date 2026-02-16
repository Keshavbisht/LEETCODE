class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int curr = 0;

        int pnt1 = 0;
        int pnt2 = -1;

        while(curr < n-k +1){
            pnt2++;
            if((pnt2 - pnt1) !=0 && nums[pnt2] != nums[pnt2-1]+1){
                while(pnt1 < pnt2 && curr < n-k+1){
                    pnt1++;
                    ans[curr] =-1;
                    curr++;
                }
            }
            else if((pnt2 - pnt1 +1) == k &&curr < n-k+1){
                ans[curr] = nums[pnt2];
                pnt1++;
                curr++;
            }

        }
        return ans;
    }
}
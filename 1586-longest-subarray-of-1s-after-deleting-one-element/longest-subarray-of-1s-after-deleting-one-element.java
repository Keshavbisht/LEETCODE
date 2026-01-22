class Solution {
    public int longestSubarray(int[] nums) {
        int pnt1 = 0;
        int pnt2 = -1;
        int ans = 0;
        int flag = 0;
        int count = 0;
        

        while(pnt2< nums.length -1){
            pnt2++;

            if(nums[pnt2] == 0){
                flag++;
            }
            else{
                count++;
            }
            while(flag>1){
                if(nums[pnt1] == 0){
                    flag--;
                }
                else{
                    count--;
                }
                pnt1++;
            }
            ans = Math.max(ans, count);
        }
        return (flag == 0) ? nums.length-1 : ans;
    }
}
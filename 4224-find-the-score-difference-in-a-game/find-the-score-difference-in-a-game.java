class Solution {
    public int scoreDifference(int[] nums) {
        int p2 = 0;
        int p1 = 0;

        boolean active = true;
        int count = 0;
        

        for(int i = 0; i< nums.length; i++){
            if(count +1 == 6){
                if(active){
                    active = false;
                }
                else{
                    active = true;
                }
                
                count = -1;
            }
            if(nums[i] %2 != 0){
                if(active){
                    active = !active;
                }
                else{
                    active = true;
                }
            }
            if(active){
                p1 += nums[i];
            }
            else{
                p2 += nums[i];
            }
            count++;
        }
        return p1 - p2;
    }
}
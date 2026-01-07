class Solution {
    public int brokenCalc(int startValue, int target) {
        int ans = 0;
        
        // if(target < startValue) return ;
        // if(startValue == target ) return 0;
        
        while(target > startValue){
            if(target % 2 != 0){
                target++;
                // ans++;
            }
            else{
                target = target/2;
                
            }
            ans++;
        }
        // if(startValue %2 == 0 && )
        return ans + startValue - target;
    }
}
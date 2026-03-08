class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int mini = Integer.MAX_VALUE;
        int ans = -1;
        
        for(int i = 0; i< capacity.length; i++){
            if(capacity[i] >= itemSize){
                if(mini > capacity[i] ){
                    ans = i;
                    mini = capacity[i];
                }
            }
        }
        return ans;
    }
}
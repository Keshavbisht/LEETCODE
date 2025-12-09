class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int low = 0;
        int high = Math.max(houses[houses.length-1], heaters[heaters.length-1]);
        int ans = 0;
        
        while(low <= high){
            
            int mid = low +(high - low)/2;
            if(helper(mid, houses, heaters)){
                ans = mid;
                high = mid -1;
            }
            else{
                low= mid+1;
            }
            
        }
        return ans;
    }
    public boolean helper(int check, int[] houses, int[] heaters){
        int ind = 0;
        for(int i = 0; i< heaters.length; i++){
            int start = heaters[i] - check;
            int end = heaters[i] + check;
            while(ind < houses.length && houses[ind] >= start && houses[ind] <= end){
                ind++;
            }
            
        }
        if(ind == houses.length) return true;
        return false;
    }
}
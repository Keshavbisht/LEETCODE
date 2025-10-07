class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = n;
        for(int i = 0; i< quantities.length; i++){
            high = Math.max(high, quantities[i]);
        }
        int ans = high;

        while(low <= high){
            int mid = low + (high-low)/2;
            int temp = 0;

            for(int i = 0; i< quantities.length; i++){
                temp = temp + (int)Math.ceil((double)quantities[i]/ mid);
            }
            if(temp <=n){
                ans = mid;
                high = mid-1;

            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
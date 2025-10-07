class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = -1;
        int high = 1;
        int ans = -1;
        for(int i = 0; i< bloomDay.length; i++){
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        while(low<=high){
            int mid = low + (high-low)/2;

            boolean check =helper(bloomDay, m, k, mid);
            if(check == true){
                ans = mid;
                high = mid-1;

            }
            else{
                low = mid+1;
            }

        }
        return ans;
    }
    public boolean helper(int[] bloomDay, int m, int k , int mid){
        int count = 0;
        int ans = 0;
        for(int i = 0; i< bloomDay.length; i++){
            if(bloomDay[i] <= mid){
                count++;
            }
            else{
                count = 0;
            }
            if(count == k){
                ans++;
                count = 0;
            }
        }
        return (ans>=m) ? true : false;
    }
}
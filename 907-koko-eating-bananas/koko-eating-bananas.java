class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long low = 1;
        long high = 0;
        for(int i =0; i< piles.length; i++){
            high += piles[i];
        }
        System.out.println(high);
        long ans = -1;

        while(low <= high){
            long mid = low + (high - low)/2;

            boolean flag = check(mid, h, piles);
            // System.out.print("MID = "+mid+" ");
            // System.out.println(flag);
            if(flag == true){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return (int)ans;
    }

    public boolean check(long a, int h, int[] piles){
        int count = 0;

        for(int i = 0; i< piles.length; i++){
            if(count > h) return false;
            int temp = (int)Math.ceil((double)piles[i]/a);
            // System.out.print(temp+" ");
            count = count + temp;
        }

        if(count <= h) return true;
        return false;
    }
}
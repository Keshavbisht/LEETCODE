class Solution {
    public long countSubarrays(int[] nums, long k) {
        int pnt1 = 0;
        int pnt2 = -1;

        int n= nums.length;

        long ans = 0;

        PriorityQueue<long[]> maxi = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        PriorityQueue<long[]> mini = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        while(pnt2 < n-1){
            pnt2++;
            maxi.add(new long[]{nums[pnt2], pnt2});
            mini.add(new long[]{nums[pnt2], pnt2});
            while(true){
                long[] currMaxi = maxi.remove();
                long[] currMini = mini.remove();
                while(currMaxi[1] < pnt1){
                    currMaxi = maxi.remove();
                }
                while(currMini[1] < pnt1){
                    currMini = mini.remove();
                }
                maxi.add(currMaxi);
                mini.add(currMini);
                
                long cost = (currMaxi[0] - currMini[0]) * (pnt2 - pnt1 +1);
                if(cost <= k) break;
                pnt1++;
            }
            
            ans = ans + (pnt2-pnt1 +1);
        }
        return ans;
    }
}
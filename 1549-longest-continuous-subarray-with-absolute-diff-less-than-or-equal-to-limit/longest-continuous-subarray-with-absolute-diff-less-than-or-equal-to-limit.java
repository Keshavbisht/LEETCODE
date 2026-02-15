class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> maxi = new PriorityQueue<>( (a, b) -> b[1] - a[1]);
        PriorityQueue<int[]> mini = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int n = nums.length;
        int pnt1 = 0;
        int pnt2 = -1;

        int ans = 0;

        while(pnt2 < n-1){
            pnt2++;

            maxi.add(new int[]{pnt2, nums[pnt2]});
            mini.add(new int[]{pnt2, nums[pnt2]});

            int[] tempMini = mini.peek();
            int[] tempMaxi = maxi.peek();
            while(Math.abs(mini.peek()[1] - maxi.peek()[1]) > limit){
                pnt1++;
                // tempMini = mini.remove();
                // tempMaxi = maxi.remove();
                while(mini.peek()[0] < pnt1){
                    mini.remove();
                }
                while(maxi.peek()[0] < pnt1){
                    maxi.remove();
                }
            }
            // mini.add(tempMini);
            // maxi.add(tempMaxi);

            ans = Math.max(ans, pnt2 - pnt1 +1);
        }
        return ans;
    }
}
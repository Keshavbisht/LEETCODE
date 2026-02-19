class Solution {
    public long continuousSubarrays(int[] nums) {
        PriorityQueue<int[]> maxi = new PriorityQueue<>((a,b)-> b[1] - a[1]);
        PriorityQueue<int[]> mini = new PriorityQueue<>( (a,b) -> a[1] - b[1]);
        int n = nums.length;
        int pnt1 = 0;
        int pnt2 = -1;
        long ans =0;

        while(pnt2 < n-1){
            pnt2++;
            maxi.add(new int[]{pnt2,nums[pnt2]});
            mini.add(new int[]{pnt2, nums[pnt2]});
            while((maxi.peek()[1] - mini.peek()[1])> 2){
                pnt1++;
                while(!maxi.isEmpty() && maxi.peek()[0] < pnt1){
                    maxi.remove();
                }
                while(!mini.isEmpty() && mini.peek()[0] < pnt1){
                    mini.remove();
                }
                
            }
            ans = ans + (pnt2 - pnt1 +1);

        }
        return ans;
    }
}
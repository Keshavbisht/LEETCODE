class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int pnt1 = 0;
        int pnt2 = -1;
        int n = nums.length;

        long[] prefix = new long[n+1];

        for(int i = 0; i< n; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new LinkedList<>();
        // int currSum = 0;
        int ans = Integer.MAX_VALUE;

        while(pnt2 < n){
            pnt2++;
            while(!dq.isEmpty() && prefix[pnt2] - prefix[dq.peekFirst()] >=k){
                ans = Math.min(ans, pnt2 - dq.removeFirst());
            }

            while(!dq.isEmpty() && prefix[pnt2] < prefix[dq.peekLast()]){
                dq.pollLast();
            }
            dq.add(pnt2);
            
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)-> a[1] - b[1]);
        for(int i = 0; i< intervals.length; i++){
            pq.add(intervals[i]);
        }
        int ans = 0;
        int curr = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            int[] temp = pq.remove();
            if(curr == Integer.MIN_VALUE){
                curr =temp[1];
            }
            else{
                if(temp[0] < curr){
                    ans++;
                }
                else{
                    curr = Math.max(curr, temp[1]);
                }
            
            }
        }
        return ans;
    }
}
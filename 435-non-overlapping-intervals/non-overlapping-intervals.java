class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int ans = 0;
        int prevEnd = intervals[0][1];
        for(int i = 1; i< intervals.length; i++){
            System.out.print(intervals[i][0]);
            System.out.println(intervals[i][1]);
            if(intervals[i][0] < prevEnd){
                ans++;
            }
            else{
                prevEnd  = Math.max(intervals[i][1], prevEnd);
            }
        }
        return ans;
    }
}
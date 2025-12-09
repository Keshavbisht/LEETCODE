class Solution {
    public int[] findRightInterval(int[][] intervals) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[intervals.length];
        for(int i = 0; i< intervals.length; i++){
            map.put(intervals[i][0], i);
            arr[i] = intervals[i][0];
        }
        Arrays.sort(arr);
        int[] ans = new int[intervals.length];
        Arrays.fill(ans, -1);
        for(int i = 0; i <intervals.length; i++){
            if(map.containsKey(intervals[i][1])){
                ans[i] = map.get(intervals[i][1]);
            }
            else{
                int x = helper(intervals[i][1], arr);
                if(x != -1){
                    ans[i] = map.get(x);
                }

            }
        }
        return ans;
    }   
    public int helper(int ind, int[] arr){
        int low = 0;
        int high = arr.length-1;
        int curr = -1;
        
        while(low<=high){
            int mid = low +(high-low)/2;
            if(arr[mid] == ind) return arr[mid];
            if(arr[mid] < ind){
                low = low+1;
            }
            else{
                high = mid-1;
                curr = arr[mid];
            }
        }
        return curr;
    }
}
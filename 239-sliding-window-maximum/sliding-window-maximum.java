class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((b,a)-> a[0] -b[0]);

        ArrayList<Integer> arr = new ArrayList<>();
        
        int pnt1 = 0;
        int pnt2 = -1;

        while(pnt2 < nums.length-1){
            pnt2++;
            pq.add(new int[]{nums[pnt2], pnt2});
            
            if(pnt2 - pnt1+1 == k){
                boolean flag = true;
                while(flag){
                    int[] temp = pq.remove();
                    if(temp[1] >= pnt1){
                        arr.add(temp[0]);
                        flag = false;
                        if(temp[1] >= pnt1+1){
                            pq.add(temp);
                        }
                    }
                }
                pnt1++;  
            }
        }
        int[] ans = new int[arr.size()];
        for(int i = 0; i< ans.length; i++){
            ans[i] = arr.get(i);
        }
        return ans;
    }
}
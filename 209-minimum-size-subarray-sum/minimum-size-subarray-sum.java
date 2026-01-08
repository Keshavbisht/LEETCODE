class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int prefix = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i< nums.length; i++){
            prefix = prefix + nums[i];
            pq.add(prefix);
            if(prefix >=target){
                while(prefix - target > pq.peek()){
                    pq.remove();
                }
                ans = Math.min(ans, pq.size());
            }
            if(map.containsKey(prefix - target)){
                ans = Math.min(ans, i - map.get(prefix -target));
            }
            map.put(prefix, i);
             
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

}
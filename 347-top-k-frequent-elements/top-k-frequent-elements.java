class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());
        for(int i = 0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
                continue;
            }
            map.put(nums[i], map.get(nums[i])+1);
        }
        pq.addAll(map.entrySet());
        int[] ans = new int[k];
        int ind = 0;
        while(ind <k){
            ans[ind] = pq.remove().getKey();
            ind++;
        }
        return ans;
    }
}
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) +1);
            }
            else{
                map.put(arr[i], 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.add(entry.getValue());
        }
        int ans = 0;
        while(k > 0){
            int temp = pq.remove();
            k = k - temp;
            if(k <0) return pq.size()+1;
            ans++;
        }
        return pq.size();

    }
}
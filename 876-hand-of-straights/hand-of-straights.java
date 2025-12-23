class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i< hand.length; i++){
            if(!map.containsKey(hand[i])){
                map.put(hand[i], 1);
            }
            else{
                map.put(hand[i], map.get(hand[i])+1);
            }
        }   
        pq.addAll(map.keySet());
        while (!pq.isEmpty()) {
            int start = pq.peek();  

            for (int i = 0; i < groupSize; i++) {
                int curr = start + i;

                if (!map.containsKey(curr)) return false;
                map.put(curr, map.get(curr) - 1);
                if (map.get(curr) == 0) {
                    map.remove(curr);
                    if (curr != pq.peek()) return false;
                    pq.poll();
                }
            }
        }
        return true;
    }
}
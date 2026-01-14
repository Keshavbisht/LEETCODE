class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> map =  new HashMap<>();
        for(int i = 0; i< matches.length; i++){
            int a = matches[i][0];
            int b = matches[i][1];
            if(!map.containsKey(a)){
                map.put(a, 0);
            }
            if(!map.containsKey(b)){
                map.put(b,-1);
            }
            else{
                map.put(b, map.get(b)-1);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        // ArrayList<Integer> loss = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int a = entry.getValue();
            int b = entry.getKey();
            if(a == 0){
                ans.get(0).add(b);
            }
            else if(a == -1){
                ans.get(1).add(b);
            }
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}
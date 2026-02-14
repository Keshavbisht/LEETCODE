class Solution {
    public int prefixConnected(String[] words, int k) {
        HashSet<String> set = new HashSet<>();
        int n = words.length;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i< n; i++){
            if(words[i].length() <k ){
                continue;
            }
            String temp = words[i].substring(0,k);
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp)+1);
            }
            else{
                map.put(temp, 1);
            }
        }
        int ans = 0;

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue() >1){
                ans++;
            }
        }
        return ans;
    }
}
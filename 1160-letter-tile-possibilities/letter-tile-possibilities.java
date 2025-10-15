class Solution {
    HashSet<String> mp = new HashSet<>();
    public int numTilePossibilities(String tiles) {
        List<String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] flag = new boolean[tiles.length()];

        helper(0, tiles, flag, sb, tiles.length(), arr);

        // for(int i = 0; i< arr.size(); i++){
            
        // }
        System.out.println(arr);
        return mp.size();


    }
    public void helper(int j, String tiles, boolean[] flag, StringBuilder sb, int n, List<String> arr){
        if(sb.length() >=1 && !mp.contains(sb.toString())){
            mp.add(sb.toString());
            arr.add(sb.toString());
        }
        // if(j>= n) return;
        
        for(int i = 0; i< tiles.length(); i++){
            if(!flag[i]){
                flag[i] = true;
                sb.append(tiles.charAt(i));
                helper(i+1, tiles, flag, sb, n, arr);
                flag[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
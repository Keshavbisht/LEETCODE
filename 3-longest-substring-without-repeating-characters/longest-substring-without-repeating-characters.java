class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int pnt1 = 0;
        int pnt2 = -1;
        int ans = -1;

        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        
        while(pnt2 < s.length()-1){
            pnt2++;
            if(!map.containsKey(s.charAt(pnt2))){
                map.put(s.charAt(pnt2), pnt2);
            }
            else{
                if(map.get(s.charAt(pnt2)) <pnt1){
                    map.put(s.charAt(pnt2), pnt2);
                }
                else{
                    pnt1 = Math.max( pnt1, map.get(s.charAt(pnt2))+1);
                    map.put(s.charAt(pnt2), pnt2);
                }
            }
            // pnt2++;
            ans = Math.max(ans, ((pnt2 - pnt1) +1));
        }
        return ans;
    }
}
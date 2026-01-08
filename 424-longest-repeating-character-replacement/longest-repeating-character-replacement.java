class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int pnt1 = 0;
        int pnt2 = -1;

        int ans = -1;
        while(pnt2<s.length()-1){
            pnt2++;
            if(!map.containsKey(s.charAt(pnt2))){
                map.put(s.charAt(pnt2), 1);
            }
            else{
                map.put(s.charAt(pnt2), map.get(s.charAt(pnt2))+1);
            }
            if(( (pnt2 - pnt1 + 1) - Collections.max(map.values()) ) > k){
                map.put(s.charAt(pnt1), map.get(s.charAt(pnt1))-1);
                pnt1++;
            }
            ans = Math.max(ans, pnt2 - pnt1 +1);
        }
        return ans;
    }
}
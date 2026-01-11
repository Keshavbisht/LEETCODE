class Solution {
    public String minWindow(String s, String t) {

        int pnt1 = 0;
        int pnt2 = -1;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int need = t.length();              
        int ans1 = 0, ans2 = 0;
        int minLen = Integer.MAX_VALUE;     

        while (pnt2 < s.length() - 1) {
            pnt2++;
            char c = s.charAt(pnt2);

            if (map.containsKey(c)) {
                if (map.get(c) > 0) need--;     
                map.put(c, map.get(c) - 1);
            }

            while (need == 0) {                
                if (pnt2 - pnt1 + 1 < minLen) {
                    minLen = pnt2 - pnt1 + 1;
                    ans1 = pnt1;
                    ans2 = pnt2;
                }

                char leftChar = s.charAt(pnt1);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);  
                    if (map.get(leftChar) > 0) need++;         
                }
                pnt1++;
            }
        }

        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(ans1, ans2 + 1);
    }
}

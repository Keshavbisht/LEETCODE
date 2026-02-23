class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int pnt1 = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<p.length(); i++){
            char temp = p.charAt(i);
            map.put(temp, map.getOrDefault(temp, 0)+1);
        }
        // for(int i : map.values()){
        //     System.out.println(i);
        // }

        for(int pnt2 = 0; pnt2 < n; pnt2++){
            char curr = s.charAt(pnt2);
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr) -1);
            }
            else{
                while(pnt1<=pnt2){
                    if(map.containsKey(s.charAt(pnt1))){
                        map.put(s.charAt(pnt1), map.get(s.charAt(pnt1)) +1);
                    }
                    pnt1++;
                }
            }

            while(Collections.min(map.values()) < 0){
                if(map.containsKey(s.charAt(pnt1))){
                    map.put(s.charAt(pnt1), map.get(s.charAt(pnt1)) +1);
                }
                pnt1++;
            }

            if(Collections.min(map.values()) == 0 && Collections.max(map.values()) == 0){
                ans.add(pnt1);
            }
        }
        return ans;
    }
}
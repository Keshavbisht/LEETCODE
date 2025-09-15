class Solution {
    public int numberOfSubstrings(String s) {
        
        
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a',-1);
        map.put('b', -1);
        map.put('c', -1);
        int b= -1;
        int n = s.length();
        int ans = 0;

        while(b<n-1){
            b++;
            char temp = s.charAt(b);
            map.put(temp, b);
            int mini = Collections.min(map.values());
            if(mini == -1) continue;
            // map.put(temp, map.get(temp)+1);

            ans = ans + mini +1;

        }
        return ans;

        
    }
}
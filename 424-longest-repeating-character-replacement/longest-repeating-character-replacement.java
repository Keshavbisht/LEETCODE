class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int a = 0;
        int b = -1;
        int ans = 0;
        int maxi = 0;

        int n = s.length();
        while(b<n-1){
            b++;
            char temp = s.charAt(b);
            if(!map.containsKey(temp)){
                map.put(temp, 1);
            }
            else{
                map.put(temp, map.get(temp)+1);
            }
            if(((b-a+1) - Collections.max(map.values()) ) > k){
                map.put(s.charAt(a), map.get(s.charAt(a)) -1);
                a++;

            }
            ans = Math.max(ans,b-a+1 );
        }
        return ans;
    }
}
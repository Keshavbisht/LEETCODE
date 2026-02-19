class Solution {
    public int takeCharacters(String s, int k) {
        int[] map = new int[3];
        int n = s.length();

        for(int i = 0; i< s.length(); i++){
            map[s.charAt(i) - 'a']++;
        }
        if(map[0] <k || map[1] < k|| map[2]<k) return -1;

        int pnt2 = -1;
        int pnt1 = 0;

        int ans = 0;
        while(pnt2 < n-1){
            pnt2++;
            char temp = s.charAt(pnt2);
            map[temp - 'a']--;
            while(map[0] <k || map[1] <k || map[2] <k){
                map[s.charAt(pnt1) - 'a']++;
                pnt1++;
            }
            ans = Math.max(ans, pnt2 - pnt1 +1);
        }

        return n - ans;
    }
}
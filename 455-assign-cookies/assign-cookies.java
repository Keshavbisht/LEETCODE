class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ind = 0;
        int ind2 = 0;
        int ans = 0;
        while(ind < g.length && ind2 < s.length){
            while(ind2 < s.length && g[ind] > s[ind2]){
                ind2++;
                // ans++;
            }
            if(ind2 >= s.length) return ans;
            if(g[ind] <= s[ind2]){
                ans++;
            }
            ind++;
            ind2++;
        }
        return ans;
    }   
}
class Solution {
    int[] rank;
    int[] par;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        par = new int[26];
        for(int i = 0; i< 26; i++){
            par[i] = i;
        }
        
        for(int i = 0; i< n ;i++){
            char one = s1.charAt(i);
            char two = s2.charAt(i);
            union(one - 'a', two - 'a');
            // if(one <= two){
            //     par[two - 'a'] = one;
            // }
            // else{
            //     par[one - 'a'] = two;
            // } 
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< baseStr.length(); i++){
            char curr = baseStr.charAt(i);
            char temp = (char) (find(curr - 'a') + 'a');
            sb.append(temp);
        }
        return sb.toString();

    }
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        if (px < py) {
            par[py] = px;
        } else {
            par[px] = py;
        }
    }
    public int find(int curr){
        if(curr == par[curr]) return curr;
        return find(par[curr]);
    }
}
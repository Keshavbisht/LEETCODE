class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] st = s.trim().split("\\s+"); 
        for(int i = st.length - 1; i >= 0; i--){
            sb.append(st[i]);
            if(i > 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

class Solution {
    public String breakPalindrome(String st) {
        StringBuilder sb = new StringBuilder(st);
        if(st.length() == 1) return "";
        // boolean flag = false;
        for(int i = 0; i< st.length()/2; i++){
            if(sb.charAt(i) >'a'){
                sb.setCharAt(i ,'a');
                return sb.toString();
            }
        } 
        
        sb.setCharAt(st.length()-1, 'b');
        
        return sb.toString();
    }
}
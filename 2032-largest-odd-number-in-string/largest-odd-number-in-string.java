class Solution {
    public String largestOddNumber(String num) {
        // int a = digits.charAt(ind) - '0';
        StringBuilder st = new StringBuilder();
        st.append(num);
        for(int i = num.length()-1; i>=0; i--){
            int a = st.charAt(i) - '0';
            if(a%2 == 0){
                st.deleteCharAt(i);
            }
            else{
                return st.toString();
            }
        }
        return st.toString();
    }
}
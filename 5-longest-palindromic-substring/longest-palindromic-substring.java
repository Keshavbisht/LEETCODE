class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0; i< s.length(); i++){
            for(int j = i; j< s.length(); j++){
                String temp = s.substring(i, j+1);
                if(check(temp) && ans.length() < temp.length()){
                    ans = temp;
                }
            }
        }
        return ans;
    }
    public boolean check(String st){
        int pnt1 = 0;
        int pnt2 = st.length()-1;
        while(pnt1 < pnt2){
            if(st.charAt(pnt1) != st.charAt(pnt2)) return false;
            pnt1++;
            pnt2--;
        }
        return true;
    }
}
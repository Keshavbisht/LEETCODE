class Solution {
    public String trimTrailingVowels(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        for(i = n-1; i>=0; i--){
            if(s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o' && s.charAt(i) != 'u'){
                break;
            }
        }
        for(int j = 0; j< i+1; j++){
            sb.append(s.charAt(j));
        }
        return sb.toString();
    }
}
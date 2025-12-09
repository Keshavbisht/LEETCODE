class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for(int i =0; i< word.length(); i++){
            char c = word.charAt(i);
            if(i == 0 && c >='A' && c<= 'Z'){
                count++;
            }
            else if(count==0 && c >='A' && c<= 'Z') return false;
            else if(c >='A' && c<= 'Z'){
                count++;
            }
        }
        return (count == word.length() || count == 1 || count == 0) ? true : false;
    }
}
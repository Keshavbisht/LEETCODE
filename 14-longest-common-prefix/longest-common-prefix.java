class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< strs[0].length(); i++){
            String temp = strs[0].substring(0,i+1);
            for(int j = 1; j< strs.length; j++){
                if(temp.length() > strs[j].length()) return sb.toString();

                if(!temp.equals(strs[j].substring(0,i+1))) return sb.toString();

            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}
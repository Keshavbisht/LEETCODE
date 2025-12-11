class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for(int i = 0; i< s.length(); i++){
            char temp  = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(temp);
            if(sb.toString().equals(goal)) return true;
        }
        return false;
    }
}
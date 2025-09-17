class Solution {
    public List<String> letterCasePermutation(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        helper(0, s, sb, ans);
        return ans;

        
    }
    public void helper(int ind, String s, StringBuilder sb, List<String> ans){
        if(sb.length() == s.length()){
            ans.add(sb.toString());
            return;
        }

        char c = s.charAt(ind);
        if(Character.isLetter(c)){
            sb.append(Character.toUpperCase(c));
            helper(ind+1, s, sb, ans);
            sb.deleteCharAt(sb.length() - 1); 

            sb.append(Character.toLowerCase(c));
            helper(ind+1, s, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        else{
            sb.append(s.charAt(ind));
            helper(ind+1, s, sb,ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}
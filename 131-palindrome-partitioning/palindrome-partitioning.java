class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(0, s,temp, ans );
        return ans;
    }
    public void helper(int ind, String s,List<String> temp, List<List<String>> ans){
        if(ind == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = ind; i< s.length(); i++){
            if(palindrome(s.substring(ind,i+1))){
                temp.add(s.substring(ind,i+1));
                helper(i+1, s, temp, ans);
                temp.remove(temp.size()-1);
            }
        }
        
    }
    public boolean palindrome(String st){
        StringBuilder sb = new StringBuilder(st);
        String a= sb.reverse().toString();
        // System.out.println(sb.reverse().toString());
        if(st.equals(a)) return true;
        return false;
    }
}
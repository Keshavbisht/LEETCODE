class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String s = "";
        helper(ans, s, n, 0, 0);
        return ans;

    }
    public void helper(List<String> ans,String s, int n, int Count_left, int Count_right){
        if(s.length() == 2*n){
            ans.add(s);
            return;
        }
        if(Count_left < n){
            helper(ans,s+"(", n, Count_left +1, Count_right);
        }
        if(Count_right < Count_left){
            helper(ans , s+")", n, Count_left, Count_right+1);
        }
    }
}

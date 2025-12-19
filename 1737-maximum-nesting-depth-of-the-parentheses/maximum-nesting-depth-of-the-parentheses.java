class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i< s.length(); i++){
            char temp = s.charAt(i);
            if(temp == '('){
                st.push('(');
            }
            if(temp == ')'){
                ans = Math.max(ans, st.size());
                st.pop();
            }
        }
        return ans;
    }
}
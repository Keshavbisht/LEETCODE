class Solution {
    public String makeGood(String s) {
        int prev = 0;
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i<s.length()){
            char curr = s.charAt(i);
            if(!st.isEmpty() && Math.abs(curr - st.peek()) == 32){
                
                st.pop();
                
            }
            else{
                st.push(curr);
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
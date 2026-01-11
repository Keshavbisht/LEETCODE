class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        boolean flag = false;
        for(int i = 0; i< s.length(); i++){
            flag = false;
            char temp = s.charAt(i);
            while(!st.isEmpty() && st.peek() == temp){
                st.pop();
                flag = true;
            }
            if(!flag){
                st.push(temp);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
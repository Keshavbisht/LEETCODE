class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(k > 0 && i<n){
            
            char curr = num.charAt(i);
            while(!st.isEmpty() && st.peek() > curr && k > 0){
                st.pop();
                System.out.println(k);
                k--;
            }
            st.push(curr);
            i++;
        } 
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        System.out.println(i);
        while(i < n){
            
            char curr = num.charAt(i);
            st.push(curr);
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        System.out.println(sb.toString());
        sb.reverse();
        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return (sb.length() == 0) ? "0" : sb.toString();

    }
}
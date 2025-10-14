class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        // st.add(num.charAt(0));
    
        for(int i = 0; i< num.length(); i++){
            char temp = num.charAt(i);

            while(!st.isEmpty() && k > 0 && st.peek() > temp ){
                st.pop();
                k--;
            }
            st.push(temp);
        }
        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        sb.reverse();

        while(sb.length() > 0 && k>0){
            sb.deleteCharAt(sb.length()-1);
            k--;
        }

        while(sb.length() >0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return (sb.length() == 0) ? "0" : sb.toString();


    }
}
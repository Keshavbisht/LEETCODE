class Solution {
    public String smallestSubsequence(String s) {
        boolean[] flag = new boolean[26];
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i< s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
            }
            else{
                map.put(s.charAt(i), i);
            }
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0; i< s.length(); i++){
            char temp = s.charAt(i);
            if(flag[temp - 'a']) continue;
            while(!st.isEmpty() && st.peek() > temp){
                if(map.get(st.peek()) > i){
                    flag[st.peek() - 'a'] = false;
                    st.pop();
                }
                else{
                    break;
                }
            }
            
            st.push(temp);
            flag[temp - 'a'] = true;
            
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
class Solution {
    public int minCost(String colors, int[] neededTime) {
        Stack<Integer> st = new Stack<>();
        int ind = 0;
        int ans = 0;
        while(ind != neededTime.length){
            if(!st.isEmpty() && colors.charAt(st.peek()) == colors.charAt(ind)){
                int a = st.peek();
                int temp = Math.min(neededTime[ind], neededTime[st.peek()]);
                if(neededTime[ind] >neededTime[st.peek()] ){
                    st.pop();
                    st.add(ind);
                }
                else{
                    st.pop();
                    st.add(a);
                }
                ans = ans + temp;
            }
            else{
                st.add(ind);
            }
            ind++;
        }
        return ans;
    }
}
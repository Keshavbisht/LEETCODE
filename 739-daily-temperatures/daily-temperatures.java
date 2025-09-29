class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> st = new Stack<>();
        int[] ans = new int[n];
        for(int i = n-1; i>=0; i--){
            int curr = temperatures[i];
            // int count = 0;
            int temp[];
            while(!st.isEmpty() ){
                temp = st.peek();
                if(temp[0] <= curr){
                    st.pop();
                }
                else{
                    break;
                }
                
            }
            if(st.isEmpty()){
                ans[i] = 0;
                st.push(new int[]{curr, i});
            }
            else{
                temp = st.peek();
                ans[i] = temp[1]-i;
                st.push(new int[]{curr, i});
            }
            

        }
        return ans;
    }
}
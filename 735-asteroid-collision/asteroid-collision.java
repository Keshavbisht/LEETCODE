class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;

        for(int i = 0; i< n; i++){
            int curr = asteroids[i];
            boolean flag = false;
            // if(!st.isEmpty() && curr <0 ){
            while(!st.isEmpty() && curr < 0 && st.peek() > 0 ){
                if(st.peek() < (curr*-1)){
                    st.pop();
                    continue;
                }
                if(st.peek() == (curr*-1)){
                    st.pop();
                }
                flag = true;
                break;
            }

            // }
            if(flag == false){
                st.push(curr);
            }

        }
        System.out.print(st.size());
        int[] ans = new int[st.size()];
        for(int i = st.size()-1; i>=0; i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}
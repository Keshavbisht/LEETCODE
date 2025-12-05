class Solution {
    Stack<Integer> st;
    boolean[] vis;
    boolean[] check;
    public int[] findOrder(int numCourses, int[][] arr) {
        st = new Stack<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i< arr.length; i++){
            int u = arr[i][0];
            int v = arr[i][1];
            adj.get(v).add(u);
        }
        vis = new boolean[numCourses];
        check = new boolean[numCourses];
        for(int i = 0; i< numCourses; i++){
            if(!vis[i]){
                if(!helper(i, adj)) return new int[]{};
            }
        }
        int[] ans = new int[st.size()];
        int i = 0;
        while(!st.isEmpty()){
            ans[i] = st.pop();
            i++;
        }
        return ans;

    }
    public boolean helper(int ind, ArrayList<ArrayList<Integer>> adj){
        vis[ind] = true;
        check[ind] = true;
        for(int i = 0; i< adj.get(ind).size(); i++){
            if(check[adj.get(ind).get(i)]) return false;
            
            
            if(!vis[adj.get(ind).get(i)]){
                if(!helper(adj.get(ind).get(i), adj)) return false;
            }
        }
        st.push(ind);
        check[ind] = false;
        return true;
    }
}
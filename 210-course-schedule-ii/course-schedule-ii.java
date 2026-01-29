class Solution {
    boolean[] vis;
    int[] ans;
    Stack<Integer> st;
    public int[] findOrder(int n, int[][] arr) {
        // BFS
        ans =new int[n];
        vis = new boolean[n];
        st = new Stack<>();


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        } 
        for(int i = 0; i< arr.length; i++){
            int u = arr[i][1];
            int v = arr[i][0];

            adj.get(u).add(v);
        }
        boolean flag[] = new boolean[n];
        for(int i = 0; i< n; i++){
            if(!vis[i]){
                if(dfs(i, adj, flag)) return new int[]{};
            }
        }
        for(int i = 0; i< n; i++){
            ans[i] = st.pop();
        }
        return ans;

        
    }

    public boolean dfs(int ind, ArrayList<ArrayList<Integer>> adj, boolean flag[]){
        if(flag[ind] ==true) return true;
        flag[ind] = true;
        vis[ind] = true;

        for(int i = 0; i< adj.get(ind).size(); i++ ){
            int temp = adj.get(ind).get(i);
            if(flag[temp] == true) return true;
            if(!vis[temp]){
                if(dfs(temp, adj, flag)) return true;
            }
        }
        flag[ind] = false;
        st.add(ind);
        return false;
    }
    
}
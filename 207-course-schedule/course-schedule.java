class Solution {
    boolean[] vis;
    boolean[] rec;
    public boolean canFinish(int V, int[][] arr) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i< arr.length; i++){
            int u = arr[i][0];
            int v = arr[i][1];

            adj.get(v).add(u);
        }

        vis = new boolean[V];
        rec = new boolean[V];

        for(int i = 0; i< V; i++){
            if(!vis[i]){
                if(!helper(i, adj)) return false;
            }
        }
        return true;
    }
    public boolean helper(int ind, ArrayList<ArrayList<Integer>> adj){
        vis[ind] = true;
        rec[ind] = true;

        for(int i = 0; i< adj.get(ind).size(); i++){
            if(rec[adj.get(ind).get(i)] == true) return false;
            if(!vis[adj.get(ind).get(i)]){
                if(!helper(adj.get(ind).get(i), adj)) return false;
            }
        }
        rec[ind] = false;
        return true;
    }
}
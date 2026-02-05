class Solution {
    boolean[] vis;
    int ans = 0;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        vis = new boolean[n+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<n; i++ ){
            for(int j = 0; j< isConnected[i].length; j++){
                if(isConnected[i][j] == 1 && j!=i){
                    adj.get(i+1).add(j+1);
                }
                // adj.get(isConnected[j]).
            }
        }
        vis[0] = true;
        for(int i = 0; i<=n; i++){
            if(!vis[i]){
                ans++;
                dfs(i, adj, -1);
            }
        }

        return ans;
    }

    public void dfs(int ind, ArrayList<ArrayList<Integer>> adj, int par){
        if(vis[ind] == true) return;
        vis[ind] = true;

        for(int i = 0; i< adj.get(ind).size(); i++){
            if(!vis[adj.get(ind).get(i)]){
                dfs(adj.get(ind).get(i), adj, ind);
            }
        }
    }
}
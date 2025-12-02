class Solution {
    int ans= 0;
    boolean[] vis;
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i = 0; i<= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i< isConnected.length; i++){
            for(int j = 0; j< isConnected[i].length; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i+1).add(j+1);
                }
            }
        }
        // System.out.println(adj);
        // return 0;
        vis = new boolean[n+1];
        for(int i = 1; i<= n; i++){
            if(!vis[i]){
                ans++;
                helper(i, adj);
            }
        }
        return ans;
    }
    public void helper(int ind, ArrayList<ArrayList<Integer>> adj){
        vis[ind] = true;
        for(int i = 0; i< adj.get(ind).size(); i++){
            if(!vis[adj.get(ind).get(i)]){
                helper(adj.get(ind).get(i), adj);
            }
        }
    }
    
}
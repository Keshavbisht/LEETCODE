class Solution {
    int color[];
    boolean vis[];
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        vis = new boolean[n];
        Arrays.fill(color, -1);

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i< n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i< n; i++){
            for(int j =0; j< graph[i].length; j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        for(int i = 0; i< n; i++){
            if(!vis[i] ){
                if(!dfs(i, 1, 0, adj)) return false;
            }
        }
        return true;

    }
    public boolean dfs(int ind, int currColor, int colorT, ArrayList<ArrayList<Integer>> adj){
        if(vis[ind] == true) return true;
        color[ind] = currColor;
        vis[ind] = true;
        for(int i = 0; i< adj.get(ind).size(); i++){
            int temp = adj.get(ind).get(i);
            if(color[temp] == -1){
                if(!dfs(temp, colorT, currColor, adj)) return false;
            }
            else if(color[temp] == color[ind]) return false;
        }
        return true;
    }
}
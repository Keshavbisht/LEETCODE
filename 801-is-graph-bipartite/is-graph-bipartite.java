class Solution {
    boolean[] vis;
    int[] color;
    public boolean isBipartite(int[][] graph) {
 
        int n = graph.length;
        // for(int i = 0; i< n; i++){
        //     Arrays.sort(graph[i]);
        // }
        vis = new boolean[n];
        color = new int[n];
        Arrays.fill(color, -1);
        // boolean ans =  helper(0, 1,graph);
        // if(n%2 != 0) return false;
        for(int i = 0; i< n;i++){
            if(color[i] == -1){
                if(!helper(i, 1, graph)) return false;
            }
        }

        return true;
        
    }
    public boolean helper(int ind,int par, int[][] graph){
        vis[ind] = true;
        color[ind] = 1 - par;
        for(int i = 0; i< graph[ind].length; i++){
            if(color[ind] == color[graph[ind][i]]) return false;
            if(vis[graph[ind][i]] == false){
                if(!helper(graph[ind][i], color[ind], graph)) return false;
            }
        }
        return true;
    }

}
class Solution {
    boolean[] vis;
    int[] color;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        vis = new boolean[n];
        color = new int[n];
        Arrays.fill(color, -1);

        // Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i< n; i++){
            if(!vis[i]){
                System.out.println(i);
                if(!bfs(i, graph)) return false;
            }
            
        }
        return true;

    }
    public boolean bfs(int ind, int[][] graph){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ind, 0});

        while(!q.isEmpty()){
            int[] curr = q.remove();
            int u = curr[0];
            color[u] = curr[1];
            vis[u] = true;

            for(int i = 0; i< graph[u].length; i++){
                if(color[u] == 0){
                    if(color[u] == color[graph[u][i]]) return false;
                    if(color[graph[u][i]] == -1 && !vis[graph[u][i]]){
                        q.add(new int[]{graph[u][i], 1});
                    }
                    
                }
                else if(color[u] == 1){
                    if(color[u] == color[graph[u][i]]) return false;
                    // q.add(new int[]{graph[u][i], 0});
                    if(color[graph[u][i]] == -1 && !vis[graph[u][i]]){
                        q.add(new int[]{graph[u][i], 0});
                    }
                }
            }
        }
        return true;

    }
}
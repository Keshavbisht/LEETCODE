class Solution {
    // int ans = 0;
    boolean[] vis;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // int n = hasApple.size();
        List<List<Integer>> adj = new ArrayList<>();
        vis = new boolean[n];
        for(int i = 0; i< n; i++){
            adj.add(new ArrayList<Integer>());
        }


        for(int i = 0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int ans = 0;
        for(int i = 0; i< adj.get(0).size(); i++){
            int a = dfs(adj.get(0).get(i), 0, adj, hasApple, n, 0);
            System.out.println(a);
            ans = ans + a;
        }
        return ans *2;



    }
    public int dfs(int ind,int curr, List<List<Integer>> adj, List<Boolean> hasApple ,int n, int par){
        // if(ind >= n-1) return 0;
        if(vis[ind]) return 0;
        vis[ind] = true;
        int ans = 0;
        boolean flag = hasApple.get(ind);
        for(int i = 0; i< adj.get(ind).size(); i++ ){
            int temp = adj.get(ind).get(i);
            if(!vis[temp] && temp != par){
                ans = ans + dfs(temp, curr+1, adj, hasApple, n, ind);
                // if(ans = curr)
            }
        }
        if(flag == true || ans > 0){
            return ans + 1;
        }
        return 0;
        
    }
}
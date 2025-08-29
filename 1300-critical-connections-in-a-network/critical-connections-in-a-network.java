class Solution {
    int timer = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< n; i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> it: connections){
            int u = it.get(0);
            int v = it.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        List<List<Integer>> ans =new ArrayList<>();
        helper(0, -1, adj, vis, ans, tin, low);
        return ans;

    }

    public void helper(int node , int par, List<List<Integer>> adj, boolean[] vis, List<List<Integer>> ans, int[] tin, int[] low){
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;

        for(int it: adj.get(node)){
            if(it == par) continue;
            if(!vis[it]){
                helper(it, node, adj, vis, ans, tin, low);
                low[node] = Math.min(low[it], low[node]);

                if(low[it] > tin[node]){
                    ans.add(Arrays.asList(it, node));
                }
            }
            else{
                low[node] = Math.min(low[node], tin[it]);
            }
            
        }

    }
}
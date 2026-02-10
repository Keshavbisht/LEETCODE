class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[graph.length];
        dfs(0, temp, ans, graph, graph.length-1,vis );
        return ans;

    }
    public void dfs(int ind, List<Integer> temp, List<List<Integer>> ans, int[][] graph, int n, boolean[] vis){
        temp.add(ind);
        if(ind == n){
            ans.add(new ArrayList<>(temp));
            
        }
        
        else{
            for(int i = 0; i< graph[ind].length; i++){
                
                dfs(graph[ind][i], temp, ans, graph, n, vis);
                
            }
        }
        temp.remove(temp.size() -1);
    }
}
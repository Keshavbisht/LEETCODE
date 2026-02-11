class Solution {
    int[] par;
    int[] rank;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        rank = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        par = new int[n];

        for(int i = 0; i< n; i++){
            adj.add(new ArrayList<>());
            par[i] = i;
            rank[i] = 1;
        }


        for(int i = 0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(vals[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(vals[i], list);
            } 
            else {
                map.get(vals[i]).add(i);
            }
        }

        boolean[] active = new boolean[n];
        int ans = 0;

        for (int value : map.keySet()) {

            for (int node : map.get(value)) {
                active[node] = true;

                for (int neighbor : adj.get(node)) {
                    if (active[neighbor]) {
                        union(node, neighbor);
                    }
                }
            }
            Map<Integer, Integer> count = new HashMap<>();
            for (int node : map.get(value)) {
                int root = find(node);
                count.put(root, count.getOrDefault(root, 0) + 1);
            }

            for (int c : count.values()) {
                ans += c * (c + 1) / 2;
            }
        }
        return ans;

    }

    public int find(int curr){
        if(par[curr] == curr) return curr;
        return find(par[curr]);
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        if (rank[px] < rank[py]) {
            par[px] = py;
            rank[py] += rank[px];
        } else {
            par[py] = px;
            rank[px] += rank[py];
        }
    }
}
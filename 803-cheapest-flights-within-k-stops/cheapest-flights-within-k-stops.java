class Solution {
    Integer[][] dp;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] f : flights) {
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }
        dp = new Integer[n][k + 2];
        int ans = dfs(src, dst, k + 1, adj);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int dfs(int node, int dst, int stops, List<List<int[]>> adj) {

        if (node == dst) return 0;
        if (stops == 0) return Integer.MAX_VALUE;

        if (dp[node][stops] != null)
            return dp[node][stops];

        int minCost = Integer.MAX_VALUE;

        for (int[] nei : adj.get(node)) {
            int next = nei[0];
            int price = nei[1];

            int cost = dfs(next, dst, stops - 1, adj);

            if (cost != Integer.MAX_VALUE) {
                minCost = Math.min(minCost, price + cost);
            }
        }

        return dp[node][stops] = minCost;
    }
}

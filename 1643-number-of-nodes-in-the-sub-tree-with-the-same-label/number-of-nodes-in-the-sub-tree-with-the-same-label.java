class Solution {
    int[] ans;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        ans = new int[n];
        dfs(0, -1, adj, labels);
        return ans;
    }

    public int[] dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, String labels) {

        int[] freq = new int[26];

        for (int nei : adj.get(node)) {
            if (nei == parent) continue;

            int[] child = dfs(nei, node, adj, labels);
            for (int i = 0; i < 26; i++) {
                freq[i] += child[i];
            }
        }

        int idx = labels.charAt(node) - 'a';
        freq[idx]++;
        ans[node] = freq[idx];

        return freq;
    }
}

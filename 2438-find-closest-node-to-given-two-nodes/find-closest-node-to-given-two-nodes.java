class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        Arrays.fill(arr1, -1);
        Arrays.fill(arr2, -1);

        dfs(node1, 0, arr1, edges);
        dfs(node2, 0, arr2, edges);

        int ans = Integer.MAX_VALUE;
        int ind = -1;

        for (int i = 0; i < n; i++) {
            if (arr1[i] != -1 && arr2[i] != -1) {
                int temp = Math.max(arr1[i], arr2[i]);
                if (temp < ans) {
                    ans = temp;
                    ind = i;
                }
            }
        }
        return ind;
    }

    public void dfs(int ind, int count, int[] arr, int[] edges) {
        if (ind == -1 || arr[ind] != -1) return;

        arr[ind] = count;
        dfs(edges[ind], count + 1, arr, edges);
    }
}

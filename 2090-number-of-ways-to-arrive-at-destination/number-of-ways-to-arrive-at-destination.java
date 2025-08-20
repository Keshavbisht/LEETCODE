import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = (int) 1e9 + 7;

        // Building adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new int[]{roads[i][1], roads[i][2]});
            adj.get(roads[i][1]).add(new int[]{roads[i][0], roads[i][2]});
        }

        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);

        long[] ways = new long[n];
        Arrays.fill(ways, 0);

        distance[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        q.offer(new long[]{0, 0}); 

        while (!q.isEmpty()) {
            long[] curr = q.poll();
            long d = curr[0];
            int node = (int) curr[1];

            if (d > distance[node]) continue;

            for (int[] edge : adj.get(node)) {
                int next = edge[0];
                long newDist = d + edge[1];

                if (newDist < distance[next]) {
                    distance[next] = newDist;
                    ways[next] = ways[node];
                    q.offer(new long[]{newDist, next});
                } else if (newDist == distance[next]) {
                    ways[next] = (ways[next] + ways[node]) % mod;
                }
            }
        }

        return (int) (ways[n - 1] % mod);
    }
}

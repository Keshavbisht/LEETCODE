class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] f : flights){
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});

        int stops = 0;

        while(!queue.isEmpty() && stops <= k){
            int size = queue.size();

            int[] tempDist = Arrays.copyOf(dist, n);

            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int node = curr[0];
                int cost = curr[1];

                for(int[] nei : adj.get(node)){
                    int next = nei[0];
                    int price = nei[1];

                    if(cost + price < tempDist[next]){
                        tempDist[next] = cost + price;
                        queue.offer(new int[]{next, tempDist[next]});
                    }
                }
            }

            dist = tempDist;
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

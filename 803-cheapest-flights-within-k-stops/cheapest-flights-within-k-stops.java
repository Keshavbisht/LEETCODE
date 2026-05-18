class Solution {
    int ans = Integer.MAX_VALUE;
    int level = 0;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i< n; i++){
            adj.add(new ArrayList<>());
        }
        int[] checkPoint = new int[n];
        Arrays.fill(checkPoint, Integer.MAX_VALUE);
        for(int i = 0 ; i< n ;i++){
            System.out.println(checkPoint[i]+" ");
        }
        

        for(int i = 0; i< flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            adj.get(u).add(new int[]{v, flights[i][2]});
            // System.out.println(adj.get(u).get(0)[0] + " " + adj.get(u).get(0)[1]);
        }
        // for(int i = 0; i< n; i++){
        //     for(int j = 0; j< adj.get(i).size(); j++){
        //         System.out.println(adj.get(i).get(j)[0] + " " + adj.get(i).get(j)[1]);
        //     }
        // }



        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{src, 0});
        q.add(new int[]{-1});

        int counter = 0;
        while(!q.isEmpty()){
            counter++;
            // System.out.println(counter);
            int[] curr = q.remove();

            if(curr[0] == -1){
                q.add(new int[]{-1});
                if(level > k || q.isEmpty())  return (ans == Integer.MAX_VALUE) ? -1: ans;
                level++;
            }

            else{
                if(curr[0] == dst){
                    ans = Math.min(ans, curr[1]);
                }
                for(int i = 0; i< adj.get(curr[0]).size(); i++){
                    int[] temp = adj.get(curr[0]).get(i);
                    // System.out.println(temp[1]);

                    if(curr[1] + temp[1] <= checkPoint[temp[0]]){
                        // System.out.println("PLEASE");
                        q.add(new int[]{temp[0], curr[1] + temp[1]});
                        checkPoint[temp[0]] = curr[1] + temp[1];
                    }
                }
            }
            
        }

        
            
        
        return (ans == Integer.MAX_VALUE) ? -1: ans;
    }
}
class Solution {
    int ans = 0;
    
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        // System.out.println(n);
        
        int m = maze[0].length;
        // System.out.println(m);
        int[][] vis = new int[n+1][m+1];
        for(int[] itr : vis){
            Arrays.fill(itr, -1);
        }

        // int[][] check = new int[][]
        int[][] check = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    

        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        q.add(new int[]{-1, -1});
        vis[entrance[0]][entrance[1]] = 1;


        while(!q.isEmpty()){
            int[] curr = q.remove();
            int u = curr[0];
            int v = curr[1];

            if(u == -1 && v == -1){
                if(q.isEmpty()) return -1;
                ans++;
                q.add(new int[]{-1, -1});
            }
            else{
                
                for(int[] itr: check){
                    int temp1 = u + itr[0];
                    int temp2 = v + itr[1];
                    // System.out.println(temp1);
                    // System.out.println(temp2);

                    if( (temp1 > n-1 || temp1 < 0 || temp2 > m-1 || temp2 < 0)){
                        if(ans ==0 ) continue;
                        return ans;
                    }
                    else{
                        if(vis[temp1][temp2] == -1 && maze[temp1][temp2] != '+')
                        {
                            q.add(new int[]{temp1, temp2});
                            vis[temp1][temp2] = 1;
                        }
                    }
                    
                }
            }
        }
        return -1;
    }
}
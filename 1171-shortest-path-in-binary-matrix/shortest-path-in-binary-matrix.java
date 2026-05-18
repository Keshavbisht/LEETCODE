class Solution {
    int level = 1;
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int[][] check = new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        

        
        int n = grid.length;
        
        if(grid[n-1][n-1] == 1 || grid[0][0] == 1) return -1;
        if(n == 1) return 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        q.add(new int[]{-1, -1});
        
        boolean[][] vis = new boolean[n+1][n+1];
        vis[0][0] = true;

        while(!q.isEmpty()){
            int[] curr = q.remove();
            int i = curr[0];
            int j = curr[1];
            if(i ==n-1 && j == n-1) return level;
            if(curr[0] == -1){
                if(q.isEmpty() && !vis[grid.length-1][grid.length-1]) return -1;
                q.add(new int[]{-1, -1});
                level++;
            }
            else{
                for(int[] itr: check){
                    int u = itr[0];
                    int v = itr[1];
                    
                    if(i+u == n-1 && j+v == n-1) return level+1;
                    // System.out.println((i+u)+ " "+ (j+v));
                    if(i+u < n && i+u >=0 && j+v < n && j+v >= 0){
                        // System.out.println("YAA2");
                        if(!vis[i+u][j+v] && grid[i+u][j+v] == 0){
                            
                            q.add(new int[]{i+u, j+v});
                            // System.out.println("YAA");
                            vis[i+u][j+v] = true;
                        }
                    }
                }
            }
        }
        return -1;

    }
}
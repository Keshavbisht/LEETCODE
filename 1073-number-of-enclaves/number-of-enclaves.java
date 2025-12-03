class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        for(int[] itr: vis){
            Arrays.fill(itr, -1);
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(i != 0 && i!=n-1 && j!=0 && j!=m-1) continue;

                if(grid[i][j] == 1){
                    q.add(new int[]{i,j});
                    vis[i][j] = 1;
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.remove();
            int i = curr[0];
            int j = curr[1];

            if(i-1 >=0 && vis[i-1][j] == -1 && grid[i-1][j] == 1){
                q.add(new int[]{i-1, j});
                vis[i-1][j] = 1;
            }
            if(i+1 <n && vis[i+1][j] == -1 && grid[i+1][j] == 1){
                q.add(new int[]{i+1, j});
                vis[i+1][j] =1;
            }
            if(j-1 >=0 && vis[i][j-1] == -1 && grid[i][j-1] == 1){
                q.add(new int[]{i, j-1});
                vis[i][j-1] = 1;
            }
            if(j+1 <m && vis[i][j+1] == -1 && grid[i][j+1] == 1){
                q.add(new int[]{i, j+1});
                vis[i][j+1] =1;
            }
        }
        int ans = 0;
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(grid[i][j] == 1 && vis[i][j] == -1){
                    ans++;
                }
            }
        }
        return ans;
    }
}
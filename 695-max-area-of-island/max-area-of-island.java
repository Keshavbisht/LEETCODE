class Solution {
    int ans = 0;
    boolean[][] vis;
    ArrayList<int[]> check = new ArrayList<>();
    int n;
    int m;

    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        vis = new boolean[n][m];
        check.add(new int[]{0,1});
        check.add(new int[]{1,0});
        check.add(new int[]{-1,0});
        check.add(new int[]{0,-1});

        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    int temp = 0;

                    int area = dfs(i, j, grid, temp);
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;

    }
    public int dfs(int i,int j,  int[][] grid, int temp){
        if(vis[i][j] == true) return temp;
        vis[i][j] = true;
        int area = 1;

        for(int a =0; a< check.size(); a++){
            int tempI = check.get(a)[0];
            int tempJ = check.get(a)[1];
            
            if(i+tempI >=0 && i+tempI < n && j+tempJ >=0 && j+tempJ <m){
                if(!vis[i+tempI][j+tempJ] && grid[i+tempI][j+tempJ] == 1){
                    area += dfs(i+tempI, j+tempJ, grid, temp+1) ;
                }
            }
            
        }
        // ans = Math.max(ans, temp);
        return area;
    }
}
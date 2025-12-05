class Solution {
    boolean[][] vis;
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        vis = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        q.add(new int[]{-1,-1});

        int ans = 1;
        int[][] direction = new int[][]{{1, 0},{0, 1},{-1, 0},{0, -1},{1, 1},{-1, -1},{1, -1},{-1, 1}};

        while(!q.isEmpty()){
            int[] curr = q.remove();
            int i = curr[0];
            int j = curr[1];
            if(i== grid.length -1 && j == grid.length-1) return ans;
            if(i == -1){
                if(q.isEmpty() && !vis[grid.length-1][grid.length-1]) return -1;
                
                ans++;
                q.add(new int[]{-1,-1});
                
            }
            else{
                for(int a = 0; a< direction.length; a++){
                    int u = direction[a][0];
                    int v = direction[a][1];
                    if(i+u <0 || i+u>=grid.length || j+ v <0 || j+v>=grid[0].length) continue;
                    if(grid[i+u][j+v] == 0 && !vis[i+u][j+v]){
                        q.add(new int[]{i+u, j+v});
                        vis[i+u][j+v] = true;
                    }
                }
            }
        }
        return -1;
    }
}
class Solution {
    int ans = 0;
    boolean[][] vis;
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        int[][] check = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        vis = new boolean[n][m];
        // if(!helper(entrance[0], entrance[1], maze)) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        vis[entrance[0]][entrance[1]] = true;
        q.add(new int[]{-1,-1});
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int i = curr[0];
            int j = curr[1];
            if(i == 0 || i == n-1 || j == 0|| j == m-1){
                if(curr != entrance) return ans;
            }
            if(i == -1){
                if(q.isEmpty()) return -1;
                q.add(new int[]{-1, -1});
                ans++;
            }
            else{
                for(int a = 0; a<4; a++ ){
                    if(i+check[a][0] < 0|| i+check[a][0] >= n || j +check[a][1] <0 || j+check[a][1] >=m) continue;
                    if(maze[i+check[a][0]][j+check[a][1]]== '.' && !vis[i+check[a][0]][j+check[a][1]]){
                        q.add(new int[]{i+check[a][0], j+check[a][1]});
                        vis[i+check[a][0]][j+check[a][1]] = true;
                    }
                }
            }

        }
        return ans;
    }
    // public boolean helper(int i,int j, int ans, char[][] maze){
    //     vis[i][j] = true;
    //     if(i == 0 || i == n-1 || j == 0|| j == m-1) return true
    // }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }
        q.add(new int[]{-2,-2});
        int ans = 0;
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int i = curr[0];
            int j = curr[1];
            if(i == -2 && j==-2){
                if(!q.isEmpty()){
                    q.add(new int[]{-2,-2});
                    ans++;
                }
            }
            else{
                if(i-1 >= 0 && grid[i-1][j] == 1){
                    grid[i-1][j] = -1;
                    q.add(new int[]{i-1,j});
                }
                if(i+1 < n  && grid[i+1][j] == 1){
                    grid[i+1][j] = -1;
                    q.add(new int[]{i+1,j});
                }
                if(j+1 < m  && grid[i][j+1] == 1){
                    grid[i][j+1] = -1;
                    q.add(new int[]{i,j+1});
                }
                if(j-1 >=0  && grid[i][j-1] == 1){
                    grid[i][j-1] = -1;
                    q.add(new int[]{i,j-1});
                }
            }
        }
        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return ans;

    }
}
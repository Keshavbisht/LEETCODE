class Solution {
    public int numEnclaves(int[][] board) {
        int n= board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for(int a = 0; a<n; a++){
            for(int b = 0; b<m; b++){
                if(a!=0 && a != n-1 && b!= 0 && b!=m-1) continue;

                if(vis[a][b] == 0 && board[a][b] == 1){
                    q.add(new int[]{a,b});
                    vis[a][b] = 1;
                }
            }
        }

        while(!q.isEmpty()){

            int[] curr = q.remove();

            int i = curr[0];
            int j = curr[1];

            if(i-1>=0 && vis[i-1][j] == 0 && board[i-1][j] == 1){
                vis[i-1][j] = 1;
                q.add(new int[]{i-1,j});
            }
            if(i+1<n && vis[i+1][j] == 0 && board[i+1][j] == 1){
                vis[i+1][j] = 1;
                q.add(new int[]{i+1,j});
            }
            if(j-1>=0 && vis[i][j-1] == 0 && board[i][j-1] == 1){
                vis[i][j-1] = 1;
                q.add(new int[]{i,j-1});
            }
            if(j+1<m && vis[i][j+1] == 0 && board[i][j+1] == 1){
                vis[i][j+1] = 1;
                q.add(new int[]{i,j+1});
            }
        }
        int count = 0;
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(vis[i][j] != 1 && board[i][j] == 1){
                    board[i][j] = 0;
                    count++;
                }
            }
        }
        return count;
    }
}
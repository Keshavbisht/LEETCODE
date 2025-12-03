class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        for(int[] i: vis){
            Arrays.fill(i, -1);
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i< mat.length; i++){
            for(int j = 0; j< mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                    vis[i][j] = 1;
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.remove();
            int i = curr[0];
            int j = curr[1];
            
            if(i-1 >= 0 && vis[i-1][j] == -1){
                mat[i-1][j] = mat[i][j] +1;
                q.add(new int[]{i-1, j});
                vis[i-1][j] = 1;
            }
            if(i+1 <n && vis[i+1][j] == -1){
                mat[i+1][j] = mat[i][j] +1;
                q.add(new int[]{i+1, j});
                vis[i+1][j] = 1;
            }
            if(j-1 >= 0 && vis[i][j-1] == -1){
                mat[i][j-1] = mat[i][j] +1;
                q.add(new int[]{i, j-1});
                vis[i][j-1] = 1;
            }
            if(j+1 < m && vis[i][j+1] == -1){
                mat[i][j+1] = mat[i][j] +1;
                q.add(new int[]{i, j+1});
                vis[i][j+1] = 1;
            }
        }
        return mat;
    }
}
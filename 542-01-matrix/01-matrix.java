class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // List<List<Integer>> mapZero = new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[m][n];

        for(int a = 0; a< mat.length; a++){
            for(int b = 0; b<mat[0].length; b++){
                if(mat[a][b] == 0){
                    q.add(new int[]{a,b});
                    vis[a][b] = 1;
                }
            }
        }

        while(!q.isEmpty()){

            int[] curr = q.remove();
            
            
            int i = curr[0];
            int j = curr[1];
                

            if(i-1>=0 && vis[i-1][j] == 0){
                mat[i-1][j] = mat[i][j] +1;
                vis[i-1][j] = 1;
                q.add(new int[]{i-1,j});
            }
            if(i+1<m && vis[i+1][j] == 0){
                mat[i+1][j] = mat[i][j] +1;
                vis[i+1][j] = 1;
                q.add(new int[]{i+1,j});
            }
            if(j-1>=0 && vis[i][j-1] == 0){
                mat[i][j-1] = mat[i][j] +1;
                vis[i][j-1] = 1;
                q.add(new int[]{i,j-1});
            }
            if(j+1<n && vis[i][j+1] == 0){
                mat[i][j+1] = mat[i][j] +1;
                vis[i][j+1] = 1;
                q.add(new int[]{i,j+1});
            }
            
        }

        return mat;
    }
}
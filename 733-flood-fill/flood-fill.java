class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image[sr][sc];
        if(n == color) return image;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int i = curr[0];
            int j = curr[1];

            image[i][j]=color;

            if(i-1 >=0 && image[i-1][j] == n){
                q.add(new int[]{i-1, j});
            }

            if(j-1 >=0 && image[i][j-1] == n){
                q.add(new int[]{i, j-1});
            }
            if(j+1 < image[0].length && image[i][j+1] == n){
                q.add(new int[]{i, j+1});
            }
            if(i+1 < image.length && image[i+1][j] == n){
                q.add(new int[]{i+1, j});
            }

        }
        return image;
    }
}
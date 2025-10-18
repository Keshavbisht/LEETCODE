class Solution {
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int startX = 0, startY = 0;
        int emptyCount = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                    emptyCount++;
                } else if(grid[i][j] == 0){
                    emptyCount++;
                } else if(grid[i][j] == 2){
                   
                    emptyCount++;
                }
            }
        }

        boolean[][] visited = new boolean[n][m];
        return helper(startX, startY, grid, n, m, visited, emptyCount);
    }

    public int helper(int i, int j, int[][] grid, int n, int m, boolean[][] visited, int remaining){

        if(i < 0 || i >= n || j < 0 || j >= m) return 0;

        if(grid[i][j] == -1 || visited[i][j]) return 0;

        if(grid[i][j] == 2){
            return remaining == 1 ? 1 : 0;
        }

        visited[i][j] = true;

        int paths = 0;
        paths += helper(i + 1, j, grid, n, m, visited, remaining - 1);
        paths += helper(i - 1, j, grid, n, m, visited, remaining - 1);
        paths += helper(i, j + 1, grid, n, m, visited, remaining - 1);
        paths += helper(i, j - 1, grid, n, m, visited, remaining - 1);

        visited[i][j] = false;

        return paths;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        List<List<Integer>> start = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i< m; i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == 2){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    start.add(temp);
                }
            }
        }


        int ans = bfs(start, grid, m, n);
        for(int a = 0; a< m; a++){
            for(int b = 0; b< n; b++){
                if(grid[a][b] == 1) return -1;
            }
        }
        return ans;


    }
    public int bfs(List<List<Integer>> start, int[][] grid, int m, int n){
        Queue<List<Integer>> q = new LinkedList<>();
        for(int a = 0; a< start.size(); a++){
            q.add(start.get(a));
        }
        q.add(null);
        int time = 0;
        while(!q.isEmpty()){
            List<Integer> curr = q.remove();
            if(curr == null){
                if(q.isEmpty()) return time;
                time++;
                q.add(null);
            }
            else{
                int i = curr.get(0);
                int j = curr.get(1);
                if(i-1 >= 0 && grid[i-1][j] == 1){
                    grid[i-1][j] = 2;
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i-1);
                    temp.add(j);
                    q.add(temp);
                }
                if(i+1 <m && grid[i+1][j] == 1){
                    grid[i+1][j] = 2;
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i+1);
                    temp.add(j);
                    q.add(temp);
                }
                if(j-1 >= 0 && grid[i][j-1] == 1){
                    grid[i][j-1] = 2;
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j-1);
                    q.add(temp);
                }
                if(j+1 <n && grid[i][j+1] == 1){
                    grid[i][j+1] = 2;
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j+1);
                    q.add(temp);
                }
            }
        }
        
        return time;
    }
}
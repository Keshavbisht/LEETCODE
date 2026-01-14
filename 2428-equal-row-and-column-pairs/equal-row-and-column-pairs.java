class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<Integer, String> rows = new HashMap<>();
        HashMap<Integer, String> columns = new HashMap<>();
        int n = grid.length;
        for(int i = 0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                sb.append(grid[i][j]).append('#');
            }
            rows.put(i, sb.toString());
        }
        for(int i = 0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                sb.append(grid[j][i]).append('#');
            }
            columns.put(i, sb.toString());
        }
        int ans = 0;
        ArrayList<int[]> flag = new ArrayList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j < n; j++){
                // int[] temp = new int[]{i,j};
                // Arrays.sort(temp);
                if(rows.get(i).equals(columns.get(j))){
                    // int[] temp = new int[]{i,j};
                    // Arrays.sort(temp);
                    // flag.add(temp);
                    ans++;
                }
            }
        }
        return ans;
    }
}
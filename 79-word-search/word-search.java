class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean flag[][] = new boolean[n][m];
        for(boolean[] itr: flag){
            Arrays.fill(itr, false);
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(word.length() == 1) return true;
                    if(helper(i, j, 1, board, word, n, m, flag)) return true;
                }
            }
        }
        return false;

    }

    public boolean helper(int i, int j, int k ,char[][] board, String word, int n, int m,boolean flag[][]){
        if(i >=n || j>= m || flag[i][j] == true) return false;
        if(k == word.length()) return true;
        flag[i][j] = true;
        if(i+1 < n && board[i+1][j] == word.charAt(k)){
            // flag[i+1][j] = true;
            if(helper(i+1, j, k+1, board, word, n, m, flag)) return true;
            // flag[i+1][j] = false;
        }
        if(i-1 >=0 && board[i-1][j] == word.charAt(k)){
            // flag[i-1][j] = true;
            if(helper(i-1, j, k+1, board, word, n, m, flag)) return true;
            // flag[i-1][j] = false;
        }
        if(j+1< m && board[i][j+1] == word.charAt(k)){
            // flag[i][j+1] = true;
            if(helper(i, j+1, k+1, board, word, n, m, flag)) return true;
            // flag[i][j+1] = false;
        }
        if(j-1 >= 0 && board[i][j-1] == word.charAt(k)){
            // flag[i][j-1] = true;
            if(helper(i, j-1, k+1, board, word, n, m, flag)) return true;
            // flag[i][j-1] = false;
        }
        flag[i][j] = false;

        return false;
    }
}
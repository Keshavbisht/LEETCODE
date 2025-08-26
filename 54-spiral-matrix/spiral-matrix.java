class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;
        
        int a = 1;

        int up = 0;
        int down = n - 1;
        int right = 0;
        int left = m - 1;

        while (true) {
            if (a == 1) {
                for (int i = right; i <= left; i++) {
                    if (matrix[up][i] == Integer.MIN_VALUE) break;
                    ans.add(matrix[up][i]);
                    matrix[up][i] = Integer.MIN_VALUE;
                }
                up++;
            }
            else if (a == 2) {
                for (int i = up; i <= down; i++) {
                    if (matrix[i][left] == Integer.MIN_VALUE) break;
                    ans.add(matrix[i][left]);
                    matrix[i][left] = Integer.MIN_VALUE;
                }
                left--;
            }
            else if (a == 3) {
                for (int i = left; i >= right; i--) {
                    if (matrix[down][i] == Integer.MIN_VALUE) break;
                    ans.add(matrix[down][i]);
                    matrix[down][i] = Integer.MIN_VALUE;
                }
                down--;
            }
            else if (a == 4) {
                for (int i = down; i >= up; i--) {
                    if (matrix[i][right] == Integer.MIN_VALUE) break;
                    ans.add(matrix[i][right]);
                    matrix[i][right] = Integer.MIN_VALUE;
                }
                right++;
                a = 0;
            }
            a++;

            if (up > down || right > left) break;
        }

        return ans;
    }
}

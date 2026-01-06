class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum1 = 0;
        // long tempSum= 0;
        long small = Integer.MAX_VALUE;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                if(matrix[i][j]<0){
                    arr.add(-1 * matrix[i][j]);
                    // tempSum += matrix[i][j];
                }
                small = Math.min(small,Math.abs(matrix[i][j]) );
                sum1 = sum1 + Math.abs(matrix[i][j]);
            }
        }
        // System.out.println(arr.get(arr.size()-1));
        if(arr.size()%2 != 0) return sum1 - small*2 ;
        return sum1;
    }
}
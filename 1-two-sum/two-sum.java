class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int point2 = nums.length-1;
        int point1 = 0;
        int sum1 = 0;
        int[][] check = new int[point2 + 1][2];
        for(int i = 0; i< nums.length; i++){
            check[i][0] = nums[i];
            check[i][1] = i;
        }
        Arrays.sort(check, (a, b) -> a[0] - b[0]);
        while(point1<point2){
            sum1 = check[point1][0] + check[point2][0];
            if(sum1 == target) return new int[]{check[point1][1], check[point2][1]};
            else if(sum1 > target){
                point2--;
            }
            else{
                point1++;
            }
        }
        return new int[]{};
        
    }
}
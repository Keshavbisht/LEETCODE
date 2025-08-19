class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftArray = new int[n];
        int[] rightArray = new int[n];
        int maxi = height[0];
        for(int i = 0; i< n; i++){
            maxi = Math.max(maxi, height[i]);
            leftArray[i] = maxi;
            System.out.print(" "+ leftArray[i]);
        }

        maxi = height[n-1];
        for(int i = n-1; i>=0; i--){
            maxi = Math.max(maxi, height[i]);
            rightArray[i] = maxi;
        }

        int sum1 = 0;
        for(int i = 1; i<n-1; i++){
            sum1 = sum1 + (Math.min(leftArray[i], rightArray[i]) - height[i]);

        }
        return sum1;
    }
}
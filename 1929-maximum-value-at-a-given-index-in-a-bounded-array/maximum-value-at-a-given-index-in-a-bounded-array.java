class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long low = 1;
        long high = maxSum;
        long ans= -1;

        while(low <= high){
            long mid = low + (high-low)/2;

            boolean flag = helper(mid, n, index, maxSum);
            if(flag){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return (int) ans;
    }
    public boolean helper(long a, int n, int index, int maxSum){
        long left = 0;
        long right = 0;

        if (a > index) {
            left += (long)a * index - (long)index * (index + 1) / 2;
        } 
        else {
            long ones = index - a + 1;
            left += (long)a * (a - 1) / 2 + ones;
        }

        int rightCount = n - index - 1;
        if (a > rightCount) {
            right += (long)a * rightCount - (long)rightCount * (rightCount + 1) / 2;
        } 
        else {
            long x = rightCount - a + 1;
            right += (long)a * (a - 1) / 2;
            right += x;
        }

        return (left+right+a <= maxSum) ? true : false;
    }
}
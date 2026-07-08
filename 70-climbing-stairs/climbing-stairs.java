class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return helper(1, 0, 1, n);
    }
    public int helper(int i, int a, int b, int n){
        if(i >= n){
            return a+b;
        }
        return helper(i+1, b, a+b, n);
    }
}
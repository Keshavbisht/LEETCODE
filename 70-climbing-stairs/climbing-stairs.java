class Solution {
    public int climbStairs(int n) {
        int a = 0;
        int b = 1;
        int ans = 0;
        for(int i = 0; i< n; i++){
            ans = a+b;
            a = b;
            b = ans;
        }
        return ans;
    }

}
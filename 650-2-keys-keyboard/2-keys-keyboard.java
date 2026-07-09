class Solution {
    public int minSteps(int n) {
        return helper(1, n, 0);
    }
    public int helper(int curr, int n , int copy){
        if(curr == n) return 0;
        if(curr > n ) return Integer.MAX_VALUE;
        
        int a = Integer.MAX_VALUE;
        int b= Integer.MAX_VALUE;

        if(copy > 0 && copy + curr <=n){
            a = helper(copy+curr, n, copy);
            if(a != Integer.MAX_VALUE){
                a = 1 + a;
            }
        }
        if(copy < curr && curr + curr <= n){
            b = helper(curr + curr, n, curr);
            if(b != Integer.MAX_VALUE){
                b = 2 +b;
            }
        }
        return Math.min(a, b);
        

    }
}
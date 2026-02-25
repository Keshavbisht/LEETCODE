class Solution {
    public boolean isUgly(int n) {
        if(n==0) return false;
        return helper(n);
    }
    public boolean helper(int n){
        if(n == 1) return true;
        if(n %2 == 0) return helper(n/2);
        if(n %3 == 0) return helper(n/3);
        if(n %5 == 0) return helper(n/5);
        return false;
    }
}
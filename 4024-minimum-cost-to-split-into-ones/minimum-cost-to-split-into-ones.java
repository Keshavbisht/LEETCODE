class Solution {
    public int minCost(int n) {
        return (int) Math.ceil((n * (n-1))/2);
    }
}
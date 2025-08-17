class Solution {
    public int maxProfit(int[] prices) {
        int minPrice= Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;

        for(int i = 0; i< prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);

        }
        return (profit <=0) ? 0: profit;
    }
}
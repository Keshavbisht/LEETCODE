class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int total = 0;
        int ans = 0;
        for(int i = 0; i< costs.length; i++){
            
            if(total+costs[i]> coins) return ans;
            ans++;
            total = total + costs[i];
        }
        return ans;

        
    }
}
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0;
        int rSum = 0;
        for(int i = 0; i< k; i++){
            lSum += cardPoints[i];
        }
        int a = k-1;
        int n = cardPoints.length;
        int maxi = Math.max(lSum, rSum);
        int b = n-1;
        while(b > n-1-k){
            lSum = lSum - cardPoints[a];
            rSum = rSum + cardPoints[b];
            maxi = Math.max(maxi,lSum+ rSum);
            a--;
            b--;
        }
        return maxi;
    }
}
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        Arrays.sort(tokens);
        int pnt1 = 0;
        int pnt2 = tokens.length-1;
        int maxi = -1;
        int ans = 0;
        // if(tokens[0] > power) return 0;
        while(pnt1 <= pnt2){
            if(tokens[pnt1] <= power){
                power = power - tokens[pnt1];
                ans++;
                pnt1++;
                maxi = Math.max(maxi, ans);
            }
            else if(ans >=1){
                power = power + tokens[pnt2];
                pnt2--;
                ans--;
            }
            else{
                return (maxi>=0) ? maxi : 0;
            }
        }
        return (maxi>=0) ? maxi : 0;
    }
}
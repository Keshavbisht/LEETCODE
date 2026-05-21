class Solution {
    int ans = 0;
    public int bagOfTokensScore(int[] tokens, int power) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(tokens);
        int n = tokens.length;
        int pnt1 = 0;
        int pnt2 = n-1;
        int score = 0;

        while(pnt1<=pnt2){
            if(power >= tokens[pnt1]){
                power = power - tokens[pnt1];
                score +=1;
                pnt1++;
                
            }
            else if(score >=1){
                
                power = power + tokens[pnt2];
                score -=1;
                pnt2--;
                
            }
            else{
                pnt1++;
            }
            System.out.println(power +" "+ score);
            ans = Math.max(ans, score);
        }
        return ans;
    }
}
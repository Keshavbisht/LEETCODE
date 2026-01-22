class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int countT = 0;
        int countF = 0;

        int pnt1 = 0;
        int pnt2 = -1;

        int ans = 0;

        while(pnt2 < answerKey.length() - 1){
            pnt2++;
            char temp = answerKey.charAt(pnt2);

            if(temp == 'F'){
                countF++;
            }
            else{
                countT++;
            }
            // int maxi  = Math.max(countF, countT);
            while(Math.min(countT, countF) > k){
                char a = answerKey.charAt(pnt1);
                if(a == 'F'){
                    countF--;
                }
                else{
                    countT--;
                }
                pnt1++;
            }
            ans = Math.max(ans, pnt2 - pnt1 + 1);
        }   
        return ans;

    }
}
class Solution {
    public int nthUglyNumber(int n) {
        int[] ans= new int[n+1];
        int pnt2=1 ,pnt3 = 1, pnt5 = 1;
        ans[1] = 1;
        for(int i = 2; i<=n; i++){

            int temp1 = ans[pnt2]*2;
            int temp2 = ans[pnt3]*3;
            int temp3 = ans[pnt5]*5;

            int mini = Math.min(temp1, Math.min(temp2, temp3));
            ans[i] = mini;
            if(mini == temp1){
                pnt2++;
            }
            if(mini == temp2){
                pnt3++;
            }
            if(mini == temp3){
                pnt5++;
            }
        }
        return ans[n];

    }
    
}
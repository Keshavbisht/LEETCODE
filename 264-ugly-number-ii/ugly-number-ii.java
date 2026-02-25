class Solution {
    public int nthUglyNumber(int n) {
        int[] ans = new int[n+1];
        ans[0] = 1;
        // ans[1] = 1;
        int pnt_2, pnt_3, pnt_5;
        pnt_2=pnt_3=pnt_5= 0;
        for(int i = 1; i<= n; i++){
            int temp1 = ans[pnt_2] * 2;
            int temp2 = ans[pnt_3] * 3;
            int temp3 = ans[pnt_5] * 5;

            int mini = Math.min(temp1, Math.min(temp2, temp3));
            ans[i] = mini; 

            if(temp1 == mini){
                pnt_2++;
            }
            if(temp2 == mini){
                pnt_3++;
            }
            if(temp3 == mini){
                pnt_5++;
            }
        }
        return ans[n-1];
        
    }
}
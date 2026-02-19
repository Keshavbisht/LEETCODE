class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] arr = new int[n*2];
        for (int i = 0; i < n; i++) {
            arr[i] = colors[i];
            arr[i + n] = colors[i];
        }       

        int pnt1 = 0;
        int pnt2 = -1;
        int ans= 0;

        while(pnt2 < n+k-2){
            pnt2++;

            while( pnt2 - pnt1+1 >k|| pnt1 < pnt2 && arr[pnt2] == arr[pnt2-1]){
                pnt1++;
            }
            if(pnt2 - pnt1 +1 == k){
                ans += 1;
                pnt1++;
            }
        }
        return ans;


    }
}
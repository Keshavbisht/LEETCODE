class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int pnt1 = 0;
        int pnt2 = -1;
        int n = s.length();
        int[] count = new int[2];
        count[0] = 0;
        count[1] = 0;
        int ans = 0;
        while(pnt2 < n-1){
            pnt2++;

            if(s.charAt(pnt2) == '0'){
                count[0]+=1;
            }
            else{
                count[1]+=1;
            }

            while(count[0] >k && count[1] >k){
                int temp = s.charAt(pnt1) - '0';
                count[temp] -= 1;
                pnt1++;
            }

            ans = ans + (pnt2 - pnt1 +1);
        }
        return ans;
    }
}
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] check = new int[26];
        int[] map = new int[26];
        int n = s2.length();
        char[] tempChar = s1.toCharArray();
        Arrays.sort(tempChar);
        s1 = new String(tempChar);

        int pnt1 = 0;
        int pnt2 = -1;

        while(pnt2 < n-1){
            pnt2++;

            char curr = s2.charAt(pnt2);
            map[curr - 'a'] +=1;

            if(s1.length() == (pnt2 - pnt1+1)){
                char[] temp = s2.substring(pnt1, pnt2+1).toCharArray();
                Arrays.sort(temp);
                String sorted = new String(temp);
                // System.out.println(sorted);
                if(sorted.equals(s1)) return true;
                else{
                    pnt1++;
                }
            }
            
        }
        return false;
    }
    
}
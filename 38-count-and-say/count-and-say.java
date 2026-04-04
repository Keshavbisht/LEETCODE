class Solution {
    public String countAndSay(int n) {
        return helper(n, n);

    }
    public String helper(int num, int n){
        // if(num >= n) return temp;
        if(num <= 1) return "1";
        String temp = helper(num-1, n);
        int pnt1 = 0;
        int pnt2 = 0;
        StringBuilder sb = new StringBuilder();
        while(pnt1 < temp.length()){
            
            char curr = temp.charAt(pnt1);
            while(pnt2 < temp.length() && temp.charAt(pnt2) == curr){
                pnt2++;
            }
            sb.append(pnt2 - pnt1);

            sb.append(curr);
            pnt1 = pnt2;
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }
}
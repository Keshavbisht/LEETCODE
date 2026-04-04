class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int n = chars.length;
        int pnt1 = 0;
        int pnt2 = 0;

        while(pnt1 < n){
            
            // pnt1++;
            System.out.println(pnt1);
            char temp = chars[pnt1];
            int count = 0;
            while(pnt2 < n && chars[pnt2] == temp){
                
                pnt2++;
            }
            count = pnt2 - pnt1;
            if(count == 1){
                sb.append(temp);

            }
            else{
                sb.append(temp);
                sb.append(count);
            }
            pnt1 = pnt2;
        }
        for(int i = 0; i< sb.length(); i++){
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}
class Solution {
    public int compress(char[] chars) {
        int pnt_1 = 0;
        int pnt_2 = 0;
        while(pnt_2 < chars.length){
            int count = 0;
            char curr = chars[pnt_2];
            while(pnt_2 < chars.length && chars[pnt_2] == curr){
                count++;
                pnt_2++;
            }
            chars[pnt_1++] = curr;
            if(count > 1){
                for(char c: Integer.toString(count).toCharArray()){
                    chars[pnt_1++] = c;
                
                }
            }
            
        }
        return pnt_1;
    }
}
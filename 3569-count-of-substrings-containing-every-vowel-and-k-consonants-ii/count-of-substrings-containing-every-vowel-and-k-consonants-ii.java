class Solution {
    public long countOfSubstrings(String s, int k) {
        long ans = 0;
        
        int pnt2 = -1;
        int pnt1 = 0;
        int n = s.length();
        int[] valid = new int[n];
        int tempCons = n;
        

        HashSet<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u'); 

        for(int i = n-1; i>= 0; i--){
            char temp = s.charAt(i);
            valid[i] = tempCons;
            if(!set.contains(temp)){
                tempCons = i;
            }
        }

        HashMap<Character, Integer> charMap = new HashMap<>();

        int consonant = 0;


        while(pnt2 < n-1){
            pnt2++;

            char temp = s.charAt(pnt2);
            if(set.contains(temp)){
                charMap.put(temp, charMap.getOrDefault(temp, 0)+1);
            }
            else{
                consonant++;
            }
            while(consonant > k){
                char temp2 = s.charAt(pnt1);
                if(set.contains(temp2)){
                    charMap.put(temp2, charMap.get(temp2)-1);
                    if(charMap.get(temp2) == 0){
                        charMap.remove(temp2);
                    }
                }
                else{
                    consonant--;
                }
                
                pnt1++;
            }
            while(charMap.size() == 5 && consonant ==k){
                ans = ans + valid[pnt2] - pnt2;
                char temp3 = s.charAt(pnt1);
                if(set.contains(temp3)){
                    charMap.put(temp3, charMap.get(temp3)-1);
                    if(charMap.get(temp3) == 0){
                        charMap.remove(temp3);
                    }
                }
                else{
                    consonant--;
                }
                
                pnt1++;
            }
        }
        return ans;

    }
}
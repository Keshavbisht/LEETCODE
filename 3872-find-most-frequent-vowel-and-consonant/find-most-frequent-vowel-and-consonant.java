import java.util.*;
class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> vowel = new HashMap<>();
        HashMap<Character, Integer> constant = new HashMap<>();
        HashSet<Character> st = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for(int i = 0; i< s.length(); i++){
            if(st.contains(s.charAt(i))){
                if(vowel.containsKey(s.charAt(i))){
                    vowel.put(s.charAt(i), vowel.get(s.charAt(i)) +1);
                }
                else{
                    vowel.put(s.charAt(i), 1);
                }
            }
            else{
                if(constant.containsKey(s.charAt(i))){
                    constant.put(s.charAt(i), constant.get(s.charAt(i)) +1);
                }
                else{
                    constant.put(s.charAt(i), 1);
                }
            }
        }
        int m1 = vowel.isEmpty() ? 0 : Collections.max(vowel.values());
        int m2 = constant.isEmpty() ? 0 : Collections.max(constant.values());
        return  m1+m2;
    }
}
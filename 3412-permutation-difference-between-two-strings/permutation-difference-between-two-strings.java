class Solution {
    public int findPermutationDifference(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i< s.length(); i++){
            map1.put(s.charAt(i), i);
        }
        for(int i = 0; i< t.length(); i++){
            map2.put(t.charAt(i), i);
        }
        int sum1 = 0;
        for(int i = 0; i< s.length(); i++){
            int x = map1.get(s.charAt(i));
            int y = map2.get(s.charAt(i));
            sum1 = sum1 + Math.abs(x-y);
        }
        return sum1;
    }
}
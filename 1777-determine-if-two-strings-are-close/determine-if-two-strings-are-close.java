class Solution {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();


        if(word1.length() != word2.length()) return false;

        for(int i = 0; i < word1.length(); i++ ){
            set1.add(word1.charAt(i));
            set2.add(word2.charAt(i));
            if(!map1.containsKey(word1.charAt(i))){
                map1.put(word1.charAt(i), 1);
            }
            else{
                map1.put(word1.charAt(i), map1.get(word1.charAt(i)) +1);
            }
            if(!map2.containsKey(word2.charAt(i))){
                map2.put(word2.charAt(i), 1);
            }
            else{
                map2.put(word2.charAt(i), map2.get(word2.charAt(i)) +1);
            }
        }
        if(!set1.equals(set2)) return false;
        // StringBuilder sb1 = new StringBuilder();
        // StringBuilder sb2 = new StringBuilder();
        ArrayList<Integer> sb1 = new ArrayList<>();
        ArrayList<Integer> sb2 = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry: map1.entrySet()){
            sb1.add(entry.getValue());
        }
        for(Map.Entry<Character, Integer> entry: map2.entrySet()){
            sb2.add(entry.getValue());
        }
        Collections.sort(sb1);
        Collections.sort(sb2);
        System.out.println(sb2);
        System.out.println(sb1);
        return (sb1.equals(sb2)) ? true : false;


    }
}
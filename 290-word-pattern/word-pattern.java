class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        String[] arr = s.split(" ");
        if(arr.length != pattern.length()) return false;

        for(int i = 0; i< pattern.length(); i++){
            if(map.containsKey(pattern.charAt(i)) && !map2.containsKey(arr[i])) return false;
            if(!map.containsKey(pattern.charAt(i)) && map2.containsKey(arr[i])) return false;
            if(map.containsKey(pattern.charAt(i)) && map2.containsKey(arr[i])){
                if(!map.get(pattern.charAt(i)).equals(arr[i]) || map2.get(arr[i]) != pattern.charAt(i)) return false;
            }
            // if(!map.containsKey(pattern.charAt(i)) && !map.containsKey(arr[i])){
            //     map.put(pattern.charAt(i), arr[i]);
            //     map2.put(arr[i], pattern.charAt(i));
            // }
            map.put(pattern.charAt(i), arr[i]);
            map2.put(arr[i], pattern.charAt(i));
            
        }
        return true;
        
    }
}
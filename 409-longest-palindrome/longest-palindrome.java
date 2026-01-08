class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }
            else{
                map.put(s.charAt(i), map.get(s.charAt(i)) +1);
            }
        }
        int ans = 0;
        boolean flag = false;
        if(map.size() == 1) return s.length();
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            int a = entry.getValue();
            
            if(a>1){
                ans = ans + (a/2)*2;
            }if(a%2 == 1){
                flag = true;
            }

        }
        return (flag == true) ? ans+1:ans;
    }
}
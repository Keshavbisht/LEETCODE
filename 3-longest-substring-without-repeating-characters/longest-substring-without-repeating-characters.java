class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int a = 0;
        int b = -1;
        int n = s.length();
        if(n==0) return 0;
        if(n==1) return 1;
        int count = 0;
        int maxi = -1;
        // set.add(s.charAt(a));
        while(b<n-1){
            b++;
            if(!map.containsKey(s.charAt(b))){
                map.put(s.charAt(b), b);
            }
            else{
                a = Math.max(a, map.get(s.charAt(b)) + 1);
                map.put(s.charAt(b), b);
                
            }
            count = b - a +1;
            maxi = Math.max(maxi, count);
        }
        return maxi;
    }
}
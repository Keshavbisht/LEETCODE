class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr1 = new int[26+1];
        int[] arr2 = new int[26+1];

        if(s.length() != t.length()) return false;
        for(int i = 0; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            arr1[a-'a'] = arr1[a-'a'] +1;
            arr2[b-'a'] = arr2[b-'a'] +1;
        }
        for(int i = 0; i< arr1.length; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
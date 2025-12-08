class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for(int i = 0; i< sentence.length(); i++){
            int j = sentence.charAt(i) - 'a';
            arr[j] = 1;
        }
        for(int i: arr){
            if(i == -1) return false;
        }
        return true;
    }
}
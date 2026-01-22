class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int[] prefix = new int[n];
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int curr = 0;
        for(int i = 0; i< n; i++){
            if(set.contains(s.charAt(i))){
                curr++;
                // prefix[i] = curr;
            }
            prefix[i] = curr;
            // System.out.print(prefix[i] + " ");
        }
        int ans = prefix[k-1];


        for(int i = 0; i< n; i++){
            // int temp = t- k;
            // int temp = prefix[i];
            if((i - k )>= 0){
                int temp = prefix[i] - prefix[i-k];
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}
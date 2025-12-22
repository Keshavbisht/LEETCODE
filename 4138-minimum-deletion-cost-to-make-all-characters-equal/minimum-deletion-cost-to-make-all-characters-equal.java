class Solution {
    public long minCost(String s, int[] cost) {
        long[] ch = new long[27];
        long maxi = Integer.MIN_VALUE;
        long prefix = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i< cost.length; i++){
            set.add(s.charAt(i));
            ch[s.charAt(i) - 'a'] += cost[i];
            maxi = Math.max(maxi,ch[s.charAt(i) - 'a'] );
            prefix = prefix + cost[i];
        }
        if(set.size() == 1) return 0;
        // int ans = 0;
        // for(int )
        return prefix - maxi;
    }
}
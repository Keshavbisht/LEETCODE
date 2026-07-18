class Solution {
    Boolean dp[];
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()+1];
        return helper("", s, wordDict);
    }
    public boolean helper(String temp, String s, List<String> dic){
        if(temp.equals(s)) return true;
        if(dp[temp.length()] != null) return dp[temp.length()]; 
        for(int i = 0; i< dic.size(); i++){
            String curr = temp+ dic.get(i);

            if(curr.length() <= s.length() &&  s.startsWith(dic.get(i), temp.length())){
                if(helper(curr, s, dic)){
                    dp[temp.length()] = true;
                    return true;
                }
            }
        }
        return dp[temp.length()] = false;
    }
}
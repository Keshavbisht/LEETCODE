class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        
    
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> ans = new ArrayList<>();
        StringBuilder st = new StringBuilder();
        if(digits == null || digits.length() == 0) return ans;
        helper(0, map, digits, ans, st);
        return ans;

        
    }
    public void helper(int ind,HashMap<Integer, String> map, String digits, List<String> ans, StringBuilder st){
        if(ind == digits.length()){
            ans.add(st.toString());
            return;
        }
        int a = digits.charAt(ind) - '0';
        String n = map.get(a);
        for(int i = 0; i< n.length(); i++){
            st.append(n.charAt(i));
            helper(ind+1, map, digits, ans, st);
            st.deleteCharAt(st.length()-1);
        }

    }
}
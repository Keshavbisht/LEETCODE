class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i<= numRows ;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 1; j<=i; j++){
                temp.add(1);
            }
            ans.add(temp);

        }
        if(numRows <=2) return ans;

        for(int i = 2; i< numRows; i++){
            
            for(int j = 1; j<ans.get(i).size()-1; j++){
                ans.get(i).set(j, ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
        }
        return ans;
    }
}
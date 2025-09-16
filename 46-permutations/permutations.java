class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] flag = new boolean[n];

        helper(n, nums, flag, ans, temp);
        return ans;


    }
    public void helper(int n,int[] nums, boolean[] flag,List<List<Integer>> ans, List<Integer> temp ){
        if(temp.size() == n){
            ans.add(new ArrayList<>(temp));
        }
        for(int i= 0; i< n; i++){
            if(flag[i] == false){
                flag[i] = true;
                temp.add(nums[i]);
                helper(n, nums, flag, ans, temp);
                flag[i] = false;
                temp.remove(temp.size() -1);
            }
        }
    }
}
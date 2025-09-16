class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        helper(nums, flag, ans, temp);
        return ans;

        
    }
    public void helper(int[] nums,boolean[] flag,  List<List<Integer>> ans, List<Integer> temp){
        if(temp.size() == nums.length){
            if(!ans.contains(temp)){
                ans.add(new ArrayList<>(temp));
                return;
            }
        }
        for(int i = 0; i< nums.length; i++){
            if(flag[i] == false){
                flag[i] = true;
                temp.add(nums[i]);
                helper(nums, flag, ans, temp);
                flag[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }

}
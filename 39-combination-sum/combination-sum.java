class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(0, 0, arr, target, temp, ans);
        return ans;
    }
    public void helper(int ind,int total, int[] arr, int target, List<Integer> temp, List<List<Integer>> ans){
        if(total > target || ind>= arr.length){
            return;
        }
        if(total == target){
            if(!ans.contains(temp)){
                ans.add(new ArrayList<>(temp));
            }
        }
        temp.add(arr[ind]);
        helper(ind, total+arr[ind], arr, target, temp, ans);
        temp.remove(temp.size()-1);
        helper(ind+1, total, arr, target, temp, ans);
    }
}
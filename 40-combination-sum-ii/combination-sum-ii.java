class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(0, 0, target, arr, ans, temp);
        return ans;

    }
    public void helper(int ind, int total, int target, int[] arr, List<List<Integer>> ans, List<Integer> temp){
        
        if(total == target){
            if(!ans.contains(temp)){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(ind >=arr.length || total > target)return;

        // temp.add(arr[ind]);
        // helper(ind+1, total + arr[ind], target, arr, ans, temp);
        // temp.remove(temp.size()-1);
        // helper(ind +1, total, target, arr, ans, temp);
        for(int i = ind; i< arr.length; i++){
            if(i>ind && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            temp.add(arr[i]);
            helper(i + 1, total+arr[i], target, arr, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
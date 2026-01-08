class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> arrFinal = new ArrayList<>();
        int i = 0;
        List<Integer> arr  = new ArrayList<>();
        recursion(i, target,candidates, arr, arrFinal);
        return arrFinal;
    }
    public void recursion(int i, int target, int[] candidates, List<Integer> arr, List<List<Integer>> arrFinal){
        if(i>= candidates.length || target<0 ) return;
        if(target==0){
            arrFinal.add(new ArrayList<>(arr));
            return;
        }
        // if(candidates[i] == target){
        //     arr.add(candidates[i]);
        //     arrFinal.add(new ArrayList<>(arr));
        //     return;
        // }
        
        // if(candidates[i] > target) return;
        
        arr.add(candidates[i]);
        recursion(i, target-candidates[i],candidates, arr, arrFinal);
        arr.remove(arr.size()-1);
        recursion(i+1, target,candidates, arr, arrFinal);
        
    }
}
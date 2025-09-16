class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] flag = new boolean[n];
        int[] arr = new int[n];
        for(int i = 1; i<= n; i++){
            arr[i-1] = i;
        }
        helper(n, k, arr,flag, temp, ans);
        StringBuilder sb = new StringBuilder();
        for (int num : ans.get(k - 1)) {
            sb.append(num);
        }
        return sb.toString();
    }
    public void helper(int n, int k, int[] arr, boolean[] flag, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans){
        if(temp.size() == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i< n; i++){
            if(flag[i] == false){
                flag[i] = true;
                temp.add(arr[i]);
                helper(n, k, arr, flag,temp, ans);
                flag[i] = false;
                temp.remove(temp.size()-1);

            }
        }

    }
}
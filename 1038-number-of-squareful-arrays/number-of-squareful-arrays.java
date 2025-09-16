class Solution {
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        boolean[] flag= new boolean[nums.length];
        helper(nums, flag, ans, temp);
        return ans.size();

        
    }
    public void helper(int[] nums, boolean[] flag, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp){
        if(temp.size() == nums.length){
            // for(int i = 0; i<nums.length-1; i++){
            //     int sum1 = temp.get(i) + temp.get(i+1);
            //     if(isPerfectSquare(sum1) == false) return;
            // }
            
            ans.add(new ArrayList<>(temp));
            
            return;
        }
        for(int i = 0; i< nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) continue;
            if(flag[i] == false){
                if(temp.size() > 0){
                    int sum = temp.get(temp.size()-1) + nums[i];
                        if(!isPerfectSquare(sum)) continue;
                }
                flag[i] = true;
                temp.add(nums[i]);
                helper(nums, flag, ans, temp);
                flag[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPerfectSquare(int num) {
        int root = (int)Math.sqrt(num);
        return root * root == num;
    }
}
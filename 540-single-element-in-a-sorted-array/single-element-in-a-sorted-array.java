class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
         Stack<Integer> st = new Stack<>();

        int i = -1;
        // st.push(nums[0]);
        while(i < nums.length-1){
            i++;
            if(!st.isEmpty() && st.peek() == nums[i] ){
                st.pop();
                
            }
            
            else{
                st.push(nums[i]);
            }
            
            
        }
        return st.peek();
    }
}
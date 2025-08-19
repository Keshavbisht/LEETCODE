class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i = n-1; i>=0; i--){
            st.push(nums[i]);
        }
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            st.push(nums[i]);

        }
        return ans;
    }
}
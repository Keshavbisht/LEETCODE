class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> st = new Stack<>();
        int ind = 0;
        int n = nums.length;
        // st.add(nums[0]);
        while(ind < n){
            long temp = nums[ind];
            while(!st.isEmpty() && (temp == st.peek())){
                st.pop();
                temp = 2*temp;
            }
            // else{
            //     st.add((long)nums[ind]);
            // }
            st.add( (long) temp);
            ind++;
        }
        List<Long> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        Collections.reverse(ans);
        return ans;
        
    }
}